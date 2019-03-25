// pageFormat.js -- holds any functions used by all pages in the project
//
// Kurt Schmidt
//
// 12/4/03
//
// EDITOR: tabstop=2, cols=80
//
// REVISIONS
// 12/4/03 - added image(), KS
// 12/4/03 - added iframeTxt(), KS
// 12/4/03 - changed iframeTxt to setupIframe, KS
// 12/12/03 - changed gImageAltTxt, KS
// 12/16/03 - added iframeWrapCode, KS
// 12/16/03 - changed codeDir to gCodeDir, KS
// 12/17/03 - changed text in iframeWrapCode(), KS
// 1/9/04 - removed iframeTxt, changed \" to ' in strings,
//					change image() to take only a filename, prepend gImageDir, KS
// 2/1/04 - changed the local width and height, which clashed with
//					document.width and document.height in Mozilla.
//					Created gIframeAltTxt		KS
// 2/13/04 - Wrote title in instead of using document.title (Mozilla was
//						resisting)	KS
// 6/08	- ripped out the <iframe> stuff, added <object>.  width, height no
// 				longer parameters  KS
// 7/08 - Added machinery to manipulate DOM, rather than use
//				document.write().  re-worked title() and image(), CH
// 7/08 - continuing work, removing all document.write(), working w/DOM
//
// NOTE:  machinery to help w/DOM taken from
//   http://shepherd-interactive.googlecode.com/svn/trunk/xhtml-document-write/xhtml-document-write.js

//&&&&&&&&  Project Variables   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

var gBookTitle = "Big C++, 2nd ed.";

var gImageAltTxt = "Check path and permissions";

var gIframeAltTxt =
   "Your browser does not support the &lt;iframe&gt; tag." ;

var gObjAltTxt =
   "The path or permissions are wrong, or your browser does not support the <object> tag." ;

//Keep track of when the document has been loaded
var isDOMLoaded = false;


//&&&&&&&&   Functions   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

///////////   DOM Helpers   ////////////////////////////////////

function markLoaded(){
   isDOMLoaded = true;
}

if(document.addEventListener)
   document.addEventListener('DOMContentLoaded', markLoaded, false);
if(window.addEventListener)
   window.addEventListener('load', markLoaded, false);
if(window.attachEvent)
   window.attachEvent('onload', markLoaded);

function makeMap(str)
{
   var obj = {}, items = str.split(",");
   for ( var i = 0; i < items.length; i++ )
      obj[ items[i] ] = true;
   return obj;
}

//Any script element IDs specified here will cause them to be ignored
var scriptIgnoreIDs = makeMap("_firebugConsoleInjector,_firebugConsole");

function this_script()
{
   var thisScript;
   if(isDOMLoaded) return null; 

   var htmlns = 'http://www.w3.org/1999/xhtml';

   //Get the last script element
   var scripts = document.getElementsByTagNameNS(htmlns, 'script');
   for(var i = scripts.length-1; i >= 0; i--){
      if(!scripts[i].id || !scriptIgnoreIDs[scripts[i].id]){
         thisScript = scripts[i];
         return thisScript;
      }
   }
   return null;
}

// http://www.netlobo.com/javascript-insertafter.html
// This function inserts newNode after referenceNode
function insertAfter( referenceNode, newNode )
{
    referenceNode.parentNode.insertBefore( newNode, referenceNode.nextSibling );
}

//////////   END DOM Helpers   ///////////////////////////////

//////////////////////////////////////////////////////////////////////////
// chapter - prints the chapter #
// depend:  gChptrNumber (local config.js)

function chapter()
{
	document.write(  gChptrNumber ) ;
}

//////////////////////////////////////////////////////////////////////////
// taxonomy - prints the `chapter.n,'
// depend:  gChptrNumber (local config.js)

function taxonomy( n )
{

   this_script().parentNode.childNodes[0].data += gChptrNumber + "." + n;
   /*
	with( document )
	{
		chapter() ;
		write( "." ) ;
		write( n ) ;
	}
   */
}

//////////////////////////////////////////////////////////////////////////
// section - prints the chapter.section, given the section #, inside a
// 		<span class='sectNr'> tag (for H1 containers)
// depend:  gChptrNumber (local config.js)

function section( sectNum )
{
	with( document )
	{
		write( "<span class='sectNr'>" ) ;
		taxonomy( sectNum ) ;
		write( "</span>&nbsp;&nbsp;" ) ;
	}
}

//////////////////////////////////////////////////////////////////////////
// title - sets the title of the page
// depend:  gBookTitle (this file)
//					gChptrNumber, gChptrTitle (local config.js)

function title()
{
	document.title = gBookTitle + ": Chptr. " + gChptrNumber 
				+ " -- " + gChptrTitle;
}

//////////////////////////////////////////////////////////////////////////
// image - creates centered image tag, w/alt text defined above
// depend:  gImageAltText (this file), gImageDir (local config.js)

function image( src )
{
	var path = gImageDir + "/" + src ;

	var img = document.createElement( "img" );
	img.setAttribute( "src", path );
	img.setAttribute( "alt", path + " - " + gImageAltTxt );

	if (!isDOMLoaded) 
	{
		insertAfter(this_script(), img)
	}
}

//////////////////////////////////////////////////////////////////////////
// setupObject - sets up 
// inputs:  src, the html file to be placed into the iframe
//		width, height, strings, optional.  Legal values for the associated
//			attributes of the iframe tag

function setupObject( src, fWidth, fHeight )
{
	var path = 
	with( document )
	{
		// open iframe tag
		write( "<object class='code' type='text/html' data='" );
		write( src ) ;
		write( "'>\n<p>" ) ;
		write( gObjAltTxt ) ;
		write( "</p>\n" ) ;
		write( "<br>Click <a target='bigc' href='" ) ;
		write( src ) ;
		write( "'>\n" ) ;
		write( src ) ;
		write( "</a> to view file.<br>" ) ;
		write( "\n</object>" ) ;
	}
}

////////////////////////////////////////////////////////////////////////////
// wrapCode - given a source file, s, assumes s.xhtml exists in the
//	 	Code directory.
//		Sets up <object>, and creates a link to the source, as well.
// inputs:  name of source file,
//		width, height, strings, optional.  Legal values for the associated
//		attributes of the iframe tag
// Note:  needs gCodeDir to be set (see config.js).  
//

function wrapCode( srcName )
{
	// build path to target (code, not HTML)
	var src = gCodeDir + "/" + srcName ;
	var targ - src + ".xhtml"

	var obj = document.createElement( "object" );
	obj.setAttribute( "class", "code" );
	obj.setAttribute( "type", "text/html" );
	obj.setAttribute( "data", targ );
	obj.setAttribute( "class", "code" );

	var p = document.createElement( "p" );
	p.appendChild( gObjAltTxt );

	obj.appendChild( p );

	if (!isDOMLoaded) 
	{
		insertAfter(this_script(), obj)
	}

/*
	// add a link to the source:
	with( document )
	{
		write( "\n<br><font size='-1'><i>Click <a target='bigc' href='" ) ;
		write( targ ) ;
		write( "'>" + srcName + "</a> to download plain text") ;
		write( "</i></font>\n" ) ;
	}
*/
}


