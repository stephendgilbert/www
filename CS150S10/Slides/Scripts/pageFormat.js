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
//

//&&&&&&&&  Project Variables   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

var gBookTitle = "Big C++, 2nd ed."

var gImageAltTxt = "Check path and permissions"

var gIframeAltTxt =
	"Your browser does not support the &lt;iframe&gt; tag." 

var gObjAltTxt =
	"Your browser does not support the &lt;object&gt; tag." 

//&&&&&&&&   Functions   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

//////////////////////////////////////////////////////////////////////////
// chapter - prints the chapter #
// depend:  gChptrNumber (local config.js)

function chapter()
{
	document.write(  gChptrNumber ) ;
}

//////////////////////////////////////////////////////////////////////////
// titleSlide() - sets up the chapter # and title
// depend: gBookTitle, local gChptrNumber gChptrTitle

function titleSlide()
{
	with( document )
	{
		write( "<img src='../images/cover.png' alt='" );
		write( gBookTitle ) ;
		write( "' class='cover' />\n" ) ;
		write( "<h1> Chapter " ) ;
		write(  gChptrNumber ) ;
		write( " &mdash; " ) ;
		write( gChptrTitle ) ;
		write( "</h1>\n" ) ;
	}
}

//////////////////////////////////////////////////////////////////////////
// taxonomy - prints the `chapter.n,'
// depend:  gChptrNumber (local config.js)

function taxonomy( n )
{
	with( document )
	{
		chapter() ;
		write( "." ) ;
		write( n ) ;
	}
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
	with( document )
	{
		write( "<title>" ) ;
		write( gBookTitle ) ;
		write( ":  Chptr. " ) ;
		write(  gChptrNumber ) ;
		write( " -- " ) ;
		write( gChptrTitle ) ;
		write( "</title>\n" ) ;
	}
}

//////////////////////////////////////////////////////////////////////////
// image - creates centered image tag, w/alt text defined above
// depend:  gImageAltText (this file), gImageDir (local config.js)

function image( src )
{
	var path = gImageDir + "/" + src ;

	with( document )
	{
		write( "<img src='" ) ;
		write( path ) ;
		write( "'\n" ) ;
		write( "\talt='" ) ;
		write( path ) ;
		write( " - " ) ;
		write( gImageAltTxt ) ;
		write( "'/>\n" ) ;
	}
}

//////////////////////////////////////////////////////////////////////////
// setupObject - sets up
// inputs:  src, the html file to be placed into the iframe
//		width, height, strings, optional.  Legal values for the associated
//			attributes of the iframe tag

function setupObject( src, fWidth, fHeight )
{
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
	var targ = gCodeDir + "/" + srcName ;

	// create the iframe
	setupObject( targ+".xhtml" ) ;

	// add a link to the source:
	with( document )
	{
		write( "\n<br><font size='-1'><i>Click <a target='bigc' href='" ) ;
		write( targ ) ;
		write( "'>" + srcName + "</a> to download plain text") ;
		write( "</i></font>\n" ) ;
	}
}

