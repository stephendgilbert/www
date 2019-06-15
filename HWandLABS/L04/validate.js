if (typeof String.prototype.startsWith != 'function') {
  String.prototype.startsWith = function (str){
    return this.slice(0, str.length) == str;
  };
}

if (typeof String.prototype.endsWith != 'function') {
  String.prototype.endsWith = function (str){
    return this.slice(-str.length) == str;
  };
}

$(document).ready(function() {
    $('#student_id').val(student_id);
    $('#student_name').val(student_name);
    $('#section').val(section);
    $('#lab_points').val(lab_points);
    $('#lab_no').val(lab_no);

    $('#ss-form').attr('target', 'google-result');
    $('#ss-form').submit(function() {
        validate();
        if ($('#lab_points').val() == 0)
        {
            alert('You have 0 points for this assignment.\n' +
                'Please complete at least one portion.');
            return false;
        }

        if (confirm('Do you want to submit?'))
        {
            $('#submit').hide();
            $('#validate').hide();
            $('#score').html("Thanks for your submission.");

            var data = 'student_id=' + encodeURIComponent(student_id) +
            '&lab_no=' + encodeURIComponent(lab_no) +
            '&lab_points=' + lab_points;

            //    alert('Posting with this data: \n' + data);

            $.post('http://cs170-checkresults.appspot.com/process-lab', data);


            return true;
        }

        return false;
    });
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

function isEmpty(f) {
    return f.val() == 0;
}

function fail(field, msg) {
    field.css("background-color", "#fee");
    field.next().html(msg);
}

function ok (field) {
    field.css("background-color", "#efe");
    field.next().html("");
}

function validate()
{
    var empty = check_empty();
    var points = 0;

    // Questions 1 and 2 ask for student's name, hex version
    if (! isEmpty($('#q01')) && ! isEmpty($('#q02')))
    {
        var name = $.trim($('#q01').val());
        var hex = $.trim($('#q02').val());

        var expect = "";
        for (var i = 0; i < name.length; i++)
        {
            var val = name.charCodeAt(i);
            expect += (val.toString(16) + " ").toUpperCase();
        }

        if (hex == $.trim(expect)) {
            points += 2;
            ok($('#q01'));
            ok($('#q02'));
        }
        else
        {
            fail($('#q02'), "Wrong conversion");
        }
    }

    // Question 3 - should start with C: and end with .exe
    var q3 = $('#q03');
    if (! isEmpty(q3))
    {
        if ((q3.val()).startsWith('C:\\') && (q3.val()).endsWith('.exe'))
        {
            points += 1;
            ok(q3);
        }
        else
        {
            fail(q3, "Invalid .exe path");
        }
    }

    // Question 4 - should be MZ
    var q4 = $('#q04');
    if (! isEmpty(q4))
    {
        if ((q4.val()).toUpperCase() == "MZ")
        {
            points += 1;
            ok(q4);
        }
        else
        {
            fail(q4, "Wrong header for .exe");
        }
    }


    // Question 5 - has mark's name mentioned
    var q5 = $('#q05');
    if (! isEmpty(q5))
    {
        var actual = $.trim(q5.val()).toLowerCase();

        if (actual.indexOf('mark') >= 0 && actual.indexOf('zbikowski') >= 0)
        {
            points += 1;
            ok(q5);
        }
        else
        {
            fail(q5, "Be more specific");
        }
    }

    // Question 6
    var q6 = $('#q06');
    if (! isEmpty(q6))
    {
        var actual = $.trim(q6.val()).toLowerCase();

        if (actual.indexOf('this program cannot be run in dos mode') >= 0)
        {
            points += 1;
            ok(q6);
        }
        else
        {
            fail(q6, "Exact phrase please.");
        }
    }

    // Question 7 - should end with .class
    var q7 = $('#q07');
    if (! isEmpty(q7))
    {
        if ((q7.val()).endsWith('.class'))
        {
            points += 1;
            ok(q7);
        }
        else
        {
            fail(q7, "Open .class file");
        }
    }

    // Question 8
    var q8 = $('#q08');
    if (! isEmpty(q8))
    {
        var actual = $.trim(q8.val());

        if (actual == "CA FE BA BE")
        {
            points += 1;
            ok(q8);
        }
        else
        {
            fail(q8, "Copy from MemoryView");
        }
    }

    lab_points = (points / possible_points) * 100;
    $('#lab_points').val(lab_points);

    $('#score').html(lab_points + " %");
}
