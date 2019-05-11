$(document).ready(function() {
    $('.spacer + div').hide();
    $('input[name=student_name]').val(student_name);
    $('input[name=student_id]').val(user_id);
//    $('input[name=test_name]').val(quiz_no);
    $('input[name=student_email]').val('None');
    $('body').css('width', '700px');
    $('body').css('margin', '10 auto 10 auto');
    $('body').css('border', '2px solid blue');
    $('body').css('padding', '2em');
    $('.title').css('font-size', '28pt');
});

var studentAnswers = new Array(listMap.length);
var correctAnswers = new Array(listMap.length);

function NewSubmit(f)
{
    var	MAGIC = 840;
    var	totalCorrect = 0;
    var	totalPossible = 0;
    var	numCorrect = 0;
    var	numPossible = 0;
    var	numBlank = 0;
    var	index;
    var	msg;
    var	i;

    f.student_name.value = StripSpaces(f.student_name.value);
    f.student_id.value = StripSpaces(f.student_id.value);
    f.student_email.value = StripSpaces(f.student_email.value);


    FixMR(f);
    FixMTF(f);
    index = 0;
    for (i=0; i < f.length; ++i) {
        if (f.elements[i].name.indexOf(":") > 0) {
            if (listMap.charAt(index) == "1") {
                listIndex = f.elements[i].selectedIndex;
                text = StripSpaces(f.elements[i].options[listIndex].value);
                studentAnswers[index] = text;
            } else {
                f.elements[i].value = StripSpaces(f.elements[i].value);
                text = f.elements[i].value;
                studentAnswers[index] = text;
            }

            if (text.length == 0)
                ++numBlank;
            ++index;
        }
    }


    if (f.student_name.value == "") {
        alert("Student name cannot be blank.");
        return(false);
    }

    if (numBlank > 0) {
        if (numBlank == 1)
            msg = "1 question";
        else
            msg = numBlank + " questions";
        if (!confirm("You have not answered " + msg +
            "  Are you sure you want to end the test?"))
            return(false);
    }

    index = 0;
    var scoreDetails = new Array();
    for (i=0; i < f.length; ++i) {
        if (f.elements[i].name.indexOf(":") > 0) {
            if (listMap.charAt(index) == "1") {
                listIndex = f.elements[i].selectedIndex;
                text = f.elements[i].options[listIndex].value;
            } else
                text = f.elements[i].value;

            numPossible = ptsMap[index] * MAGIC;
            if (ansMap[index] == "")
                scoreDetails[index] = "?--";
            else {
                var scoreResult = NewScoreAnswer(index, text, numPossible);
                numCorrect = scoreResult.numPoints;
                scoreDetails[index] = (scoreResult.isCorrect) ? " " : "X";
                scoreDetails[index] += (Math.round(numCorrect * 100 / MAGIC) / 100).toString();
                totalCorrect += numCorrect;
                totalPossible += numPossible;
            }

            scoreDetails[index] += "/" + (numPossible / MAGIC);
            ++index;
        }
    }

    f.score_details.value = scoreDetails.join("|");
    f.score_correct.value = Math.round(totalCorrect * 100 / MAGIC) / 100;
    f.score_possible.value = Math.round(totalPossible * 100 / MAGIC) / 100;
    if (totalPossible > 0)
        f.score_percent.value = Math.round(100.0 * totalCorrect / totalPossible);
    else
        f.score_percent.value = 0;

//    alert('f.score_details.value=' + f.score_details.value);
//    alert('f.score_percent.value=' + f.score_percent.value);
//    alert('studentAnswers=' + studentAnswers);
//    alert('correctAnswers=' + correctAnswers);

//    alert('About to post data');
    var data = 'student_name=' + encodeURIComponent(f.student_name.value) +
        '&test_name=' + encodeURIComponent(f.test_name.value) +
        '&score_percent=' + f.score_percent.value;
    try {
//        alert('data = ' + data);
        $.post('/process-quiz', data);
//        alert('Post successful');
    }
    catch (err)
    {
//        alert('Error posting: ' + err);
    }
    showStudentResults();

    return(false);
}

function NewScoreAnswer(answerIndex, responseText, pointsPossible)
{
    var answerText = TranslateAnswer(ansMap[answerIndex], answerIndex);
    correctAnswers[answerIndex] = answerText;
    var qtype = qtypeMap.charAt(answerIndex);
    var nrExactMatch = false;
    var result = new Array();

    result.numPoints = 0;
    result.isCorrect = false;

    if (qtype == "3" && answerText.substring(0, 2) == "p:") {
        answerText = answerText.substr(2);
        if (responseText.toUpperCase() == answerText.toUpperCase())
            result.isCorrect = true;
        else
            result.numPoints = MultiResponseCompare(responseText, answerText, pointsPossible);
    } else if (qtype == "6") {
        if (answerText.substring(0, 2) == "==") {
            answerText = answerText.substr(2);
            nrExactMatch = true;
        }
        if (NumericCompare(responseText, answerText, nrExactMatch))
            result.isCorrect = true;
    } else if (qtype == "7") {
        if (CompletionCompare(responseText, answerText))
            result.isCorrect = true;
    } else if (responseText.toUpperCase() == answerText.toUpperCase()) {
        result.isCorrect = true;
    }

    if (result.isCorrect)
        result.numPoints = pointsPossible;

    return(result);
}

function showStudentResults()
{
    $('select').hide();
    $('td .qnumber').each(function(i) {
        $(this).parent().css('padding-top', '1em');
        var question = $(this).parent().parent().find('div:first');
        var correct = studentAnswers[i] == correctAnswers[i];
        if (correct)
            question.css('background-color', 'honeydew');
        else
            question.css('background-color', '#FFFFCC');

        $(this).parent().next().find('div .choice').each(function(j) {
            // get the first character of the answer
            var answer = $(this).text().charAt(0).toUpperCase();
            if (answer == correctAnswers[i]) {
                $(this).parent().next().css('border-bottom', '2px dashed green');
            }
            else if (! correct && answer == studentAnswers[i]) {
                $(this).parent().next().css({'text-decoration':'line-through', 'color' : 'red'});
            }
        });
    });
}
