$(document).ready(function() {
    //~ $('#student_id').val(student_id);
    //~ $('#student_name').val(student_name);
    //~ $('#section').val(section);
    //~ $('#lab_points').val(lab_points);
    //~ $('#lab_no').val(lab_no);

    $('input[type="text"]').blur(function() {
        var id = $(this).attr('id');
        var val = $(this).val();
        if (check(id, val))
            ok($(this));
        else
            fail($(this));
    });
    //~ $('#ss-form').attr('target', 'google-result');
    //~ $('#ss-form').submit(function() {
        //~ validate();
        //~ if ($('#lab_points').val() == 0)
        //~ {
            //~ alert('You have 0 points for this assignment.\n' +
                //~ 'Please complete at least one portion.');
            //~ return false;
        //~ }

        //~ if (confirm('Do you want to submit?'))
        //~ {
            //~ $('#submit').hide();
            //~ $('#validate').hide();
            //~ $('#score').html("Thanks for your submission.");

            //~ var data = 'student_id=' + encodeURIComponent(student_id) +
            //~ '&lab_no=' + encodeURIComponent(lab_no) +
            //~ '&lab_points=' + lab_points;

            //~ //    alert('Posting with this data: \n' + data);

            //~ $.post('http://cs170-checkresults.appspot.com/process-lab', data);


            //~ return true;
        //~ }

        //~ return false;
    //~ });
    $('#validate').click(function() {validate();});
});

var possible_points = 0;

function check_empty()
{
   var empty_fields = 0;
   possible_points = 0;
    // Find and mark the empty fields
    $('input[type="text"]').each(function() {
        possible_points++;
        if (isEmpty($(this)))
        {
            empty_fields++;
            fail($(this), "* Empty");
        }
        else
            $(this).next().html("");
    });

    return empty_fields;
}

function check(id, val) {
    var ans = {
        '2a': 9,
        '2b': 7,
        '2c': 'U',
        '3a': 9,
        '3b': 8,
        '3c': 26,
        '4a': 10,
        '4b': 45,
        '4c': 27,
        '5a': 3,
        '5b': 5,
        '5c': 14.1,
        '5sum': 22,
        '6a': 3,
        '6b': 5,
        '6c': 4.7,
        '6sum': 22,
        '7a': 3,
        '7b': 6,
        '7c': 4.7,
        '7sum': 22,
        '8a': 48,
        '8b': 6,
        '8c': 4.7,
        '8sum': 22,
    };

    return ans[id] == val;
}

function isEmpty(f) {
    return f.val() == 0;
}

function fail(field, msg) {
    field.css("background-color", "#fee");
}

function ok (field) {
    field.css("background-color", "#efe");
}

function validate()
{
    var empty = check_empty();
    var points = 0;

    $('input[type="text"]').each(function() {
        var id = $(this).attr('id');
        var val = $(this).val();
        if (check(id, val)) points++;
    });

    lab_points = (points / possible_points) * 100;
    $('#lab_points').val(lab_points);

    $('#score').html(lab_points + " %");
}
