var lessons = [
    [
    /* Unit 1 */
    ["Introducing Programming"],
        ["A. Computers and Memory"],
        ["B. Software and the CPU"],
        ["C. Historic Programming"],
        ["D. What About Java?"],
        ["E. Java Basics"],
        ["Exercises"]
    ],
    [
    /* Unit 2 */
    ["Input, Output, and Processing"],
        ["A. Console Output"],
        ["B. Variables and Values"],
        ["C. Numbers"],
        ["D. Expressions"],
        ["E. Interactive Programs"],
        ["Exercises"]
    ],
    [
    /* Unit 3 */
    ["Strings, Math and Methods"],
        ["A. Side Effects"],
        ["B. Math and Characters"],
        ["C. More on Strings"],
        ["D. Formatting and Parsing"],
        ["E. Writing Procedures"],
        ["Exercises"]
    ],
    [
    /* Unit 4 */
    ["Introducing Computer Logic"],
        ["A. Parameters &amp; Functions"],
        ["B. True &amp; False"],
        ["C. Introducing Selection"],
        ["D. Introducing Loops"],
        ["E. The for Loop"],
        ["Exercises"]
    ],
    [
    /* Unit 5 */
    ["More On Logic"],
        ["A. Logical Operators"],
        ["B. Multiple Choice"],
        ["C. The while Loop"],
        ["D. Indefinite Loops"],
        ["E. Jumps and Iterators"],
        ["Exercises"]
    ],
    [
    /* Unit 6 */
    ["Array Basics"],
        ["A. Primitive Arrays"],
        ["B. Arrays and Loops"],
        ["C. Arrays and Methods"],
        ["D. OOP Concepts"],
        ["E. Sample Midterm"],
        ["Exercises"]
    ],
    [
    /* Unit 7 */
    ["Objects and Applets"],
        ["A. Java and the Web"],
        ["B. Java Applets"],
        ["C. Objects and Color"],
        ["D. Fonts and Friends"],
        ["E. Applet Graphics"],
        ["Exercises"]
    ],
    [
    /* Unit 8 */
    ["Graphical Applications"],
        ["A. ACM Graphics"],
        ["B. GImage and Friends"],
        ["C. Meet the Widgets"],
        ["D. Handling Events"],
        ["E. Introducing Animation"],
        ["Exercises"]
    ],
    [
    /* Unit 9 */
    ["User-Defined Types"],
        ["A. Defining Fields"],
        ["B. Defining Methods"],
        ["C. Encapsulation"],
        ["D. Constructors"],
        ["E. Scope and Statics"],
        ["Exercises"]
    ],
    [
    /* Unit 10 */
    ["Bugs and Testing"],
        ["A. Compiler Errors"],
        ["B. Runtime Errors"],
        ["C. Unit Tests"],
        ["D. Debugging"],
        ["E. Object Arrays"],
        ["Exercises"]
    ],
    [
    /* Unit 11 */
    ["Inheritance, Composition, and Arrays"],
        ["A. Introducing Inheritance"],
        ["B. Inheritance at Work"],
        ["C. Composite Objects"],
        ["D. Enumerated Types"],
        ["E. ArrayLists"],
        ["Exercises"]
    ],
    [
    /* Unit 12  */
    ["Interfaces and Exceptions"],
        ["A. Specification Inheritance"],
        ["B. Inner Classes"],
        ["C. 2D Arrays"],
        ["D. Handling Exceptions"],
        ["E. Practice Final"],
        ["Practice Solution"]
    ],
    [
    /* Unit 10 */
    ["Inheritance and Interfaces"],
        ["A. Subclasses"],
        ["B. Abstract Classes"],
        ["C. Interfaces"],
        ["D. Event Handling"],
        ["E. ????"],
        ["Exercises"]
    ]
];

// 2009 Summer - 12 Units
var date = [
    ['June 22','June 29'],          // Unit 1
    ['June 24','June 29'],          // Unit 2
    ['June 29','July 6'],           // Unit 3
    ['July 1','July 6'],            // Unit 4
    ['July 6','July 13'],             // Unit 5
    ['July 8','July 20'],            // Unit 6
    // ['March 23','March 29'],            // Midterm Exam
    // Spring Break: March 30 - April 5
    ['July 20','July 27'],             // Unit 7
    ['July 22','July 27'],            // Unit 8
    ['July 27','August 3'],            // Unit 9
    ['July 29','August 3'],               // Unit 10
    ['August 3','August 10'],                 // Unit 11
    ['August 5','August 10'],                // Unit 12
    ['May 18','May 24'],                // Final Exam
    ['May 25','May 31']                 // Final Makeup (Memorial Day holiday)

    ];
    // Final exams on the 17th, 19th, 22th, and 24th

function showDates(unitNo)
{
    //alert('should be here');
    document.write("Unit " + unitNo + " - " + date[unitNo-1][0] + " to " + date[unitNo-1][1]);
}

function showDeadline(unitNo)
{
    //alert('should be here');
    document.write(date[unitNo-1][1]);
}

function showHWDeadline(unitNo)
{
    //alert('should be here');
    if (unitNo < 14)
        document.write(date[unitNo][1]);
    else
        document.write(date[unitNo-1][1]);
}
function doEmail()
{
    document.write("<a href='mailto:StephenGilbert@gmail.com'>Stephen Gilbert</a>");
}
var popUpWin=0;
function popUpWindow(URLStr, left, top, width, height)
{
	if(popUpWin)
	{
		if(!popUpWin.closed) popUpWin.close();
	}
	popUpWin = open(URLStr, 'popUpWin', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,copyhistory=yes,width='+width+',height='+height+',left='+left+', top='+top+',screenX='+left+',screenY='+top+'');
}
var popUpWin2=0;
function popUpWindow2(URLStr, left, top, width, height)
{
	if(popUpWin2)
	{
		if(!popUpWin2.closed) popUpWin2.close();
	}
	popUpWin2 = open(URLStr, 'popUpWin2', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,copyhistory=yes,width='+width+',height='+height+',left='+left+', top='+top+',screenX='+left+',screenY='+top+'');
}

var popUpWin3=0;
function popUpWindow3(URLStr, left, top, width, height)
{
	if(popUpWin3)
	{
		if(!popUpWin3.closed) popUpWin3.close();
	}
	popUpWin3 = open(URLStr, 'popUpWin3', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,copyhistory=yes,width='+width+',height='+height+',left='+left+', top='+top+',screenX='+left+',screenY='+top+'');
}

var exWin=0;
function doExercise(URLStr)
{
    var str=getExURL + URLStr;
    if(exWin)
    {
        if (!exWin.closed) exWin.close();
    }
    exWin = open(str, 'exWin', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=675,height=480,left=0,top=0,screenX=0,screenY=0');
}

var quizWin=0;
function getQuiz(URLStr)
{
    var str=getQuizURL + URLStr;
    if(quizWin)
    {
        if (!quizWin.closed) quizWin.close();
    }
    quizWin = open(str, 'quizWin', 'toolbar=yes,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=675,height=480,left=0,top=0,screenX=0,screenY=0');
}

var hwWin=0;
function doHW(URLStr)
{
    var str=hwURL + URLStr;
    if(hwWin)
    {
        if (!hwWin.closed) hwWin.close();
    }
    hwWin = open(str, 'hwWin', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=675,height=480,left=0,top=0,screenX=0,screenY=0');
}

function doLab()
{
    return "<form action='" + labURL +"' method='POST' target='labWin' onsubmit='openLabWin();'>";
}

var labWin=0;
function openLabWin()
{
    if(labWin)
    {
        if (!labWin.closed) labWin.close();
    }
    labWin = open('', 'labWin', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=675,height=480,left=0,top=0,screenX=0,screenY=0');
}

function doQuiz()
{
    return "<form action='" + quizURL +"' method='POST'>";
}

var movieWin = 0;
function showMovie(movie)
{
	if(movieWin)
	{
		if(!movieWin.closed) movieWin.close();
	}
	movieWin = open("../movies/" + movie + "/player.html", 'movieWin', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=yes,copyhistory=yes,width=655,height=515');
}

function showMovie2(movie)
{
	if(movieWin)
	{
		if(!movieWin.closed) movieWin.close();
	}
	movieWin = open("../movies/" + movie + ".htm", 'movieWin', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=yes,copyhistory=yes,width=655,height=515');
}

function showPPS(movie)
{
	if(movieWin)
	{
		if(!movieWin.closed) movieWin.close();
	}
	movieWin = open("../movies/" + movie + ".mht", 'movieWin', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=yes,copyhistory=yes,width=655,height=515');
}
