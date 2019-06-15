
var student_id = ""
var student_name = "";
var section = "";
var lab_points = "0";

$(document).ready(function() {
    $('#lab_points').val(lab_points);
    $('#ss-form').attr('target', 'google-result');
    $('#ss-form').submit(function() {
        if (validate() && confirm('Do you want to submit?'))
        {
            $('#submit').hide();
            $('#validate').hide();
            $('#identify').hide();
            $('#score').html("Thanks for your submission.");

            return true;
        }

        return false;
    });
    $('#validate').click(function() {validate();});
    var dl = new Date('February 6, 2013');
    if (Date.now() > dl)
    {
        $('#submit').hide();
        $('#validate').hide();
        $('#identify').hide();
        $('.content').prepend('<div class="popup">Homework Deadline Has Passed</div>');
    }
});

var possible_points = 0;

function check_empty()
{
   var empty_fields = 0;
   possible_points = 0;
    // Find and mark the empty fields
    $('textarea').each(function() {
        possible_points++;
        if (isEmpty($(this)))
        {
            empty_fields++;
            fail($(this));
        }
        else
        {
            ok($(this));
        }
    });

    return empty_fields;
}

function isEmpty(f) {
    return f.val() == 0;
}

function fail(field) {
    field.css("background-color", "#fee");
}

function ok (field) {
    field.css("background-color", "#efe");
}

function validate() {
    var empty = check_empty();
    lab_points = ((possible_points - empty) / possible_points) * 100;
    $('#lab_points').val(lab_points);

    $('#score').html(lab_points + " %");
    var si = $('#student_id');
    var sn = $('#student_name');
    var se = $('#section');
    ok(si);
    ok(sn);
    ok(se);
    if (isEmpty(si) || isEmpty(sn) || isEmpty(se)
        || " MTWT MW TT-AFT TT-EVE ".indexOf(se.val()) == -1)
    {
        alert('ID, Name or Section empty or incorrect');
        if (isEmpty(si)) fail(si);
        if (isEmpty(sn)) fail(sn);
        if (isEmpty(se) || " MTWT MW TT-AFT TT-EVE ".indexOf(se.val()) == -1)
            fail(se);
        return false;
    }

    return true;
}

