<%@page import="dao.JichuImp"%>
<%@page import="dao.ContImp"%>
<%@page import="model.Jichu"%>
<%@page import="model.Allcontent"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>模糊查询</title>
<!--可无视-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/input/css/normalize.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/input/css/defaults.css" type="text/css" />

<!--必要样式-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/input/css/style.css" type="text/css" />
</head>
<body style="background-color:#fff9fb">
<div  style=“margin-top:-420px;margin-left:-80px”><a href="../plan/home.jsp">返回<<<<</a></div>
<div class="container">

	<h1>请输入要查询的关键字：</h1>

	<div class="faq">
		<input type="search" value="${hotname}" placeholder="请输入要查找的热词" />
		<ul>
		
			<%
			Allcontent con=new Allcontent();
			
			ContImp contImp=new ContImp();
			List<Allcontent> cons=contImp.search();
			for(int i=0;i<cons.size();i++){
				System.out.println(i);
				String alltitle=cons.get(i).getTitle00()+":   "+cons.get(i).getTitle01()+":   "+cons.get(i).getTitle02();
				
			%>
			
        	<li id="faq-1">
				
				<h2><a href="#faq-2"><%=alltitle %></a></h2>
				
				<h4><%=cons.get(i).getContent()%></h4>
				-----------------------------------------------------
				<div>
					<a href="${pageContext.request.contextPath}/domain?method='<%=cons.get(i).getTitle00() %>'"><%="关键字：  "+cons.get(i).getKeywords()%></a>
				    </div>
				    <div>
				    <a  href="${pageContext.request.contextPath}/domain?method='<%=cons.get(i).getTitle00() %>'"><%="摘要：  "+cons.get(i).getZhaiyao()%></a>
				</div>
			</li>
        	<%
        	
			}
        	%>
        	
			
		</ul>
		<div class="faq__notfound"><p>未找到引用相关热词的文章&hellip; Try &ldquo;计算机&rdquo;.</p></div>
	</div>


</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/input/js/jquery-v1.min.js"></script>
<script type="text/javascript">
'use strict';


// search & highlight

;( function( $, window, document, undefined )
{
	var $container = $( '.faq' );
	if( !$container.length ) return true;

	var $input			= $container.find( 'input' ),
		$notfound		= $container.find( '.faq__notfound' ),
		$items			= $container.find( '> ul > li' ),
		$item			= $(),
		itemsIndexed	= [];

	$items.each( function()
	{
		itemsIndexed.push( $( this ).text().replace( /\s{2,}/g, ' ' ).toLowerCase() );
	});

	$input.on( 'keyup', function( e )
	{
		if( e.keyCode == 13 ) // enter
		{
			$input.trigger( 'blur' );
			return true;
		}

		$items.each( function()
		{
			$item = $( this );
			$item.html( $item.html().replace( /<span class="highlight">([^<]+)<\/span>/gi, '$1' ) );
		});

		var searchVal = $.trim( $input.val() ).toLowerCase();
		if( searchVal.length )
		{
			for( var i in itemsIndexed )
			{
				$item = $items.eq( i );
				if( itemsIndexed[ i ].indexOf( searchVal ) != -1 )
					$item.removeClass( 'is-hidden' ).html( $item.html().replace( new RegExp( searchVal+'(?!([^<]+)?>)', 'gi' ), '<span class="highlight">$&</span>' ) );
				else
					$item.addClass( 'is-hidden' );
			}
		}
		else $items.removeClass( 'is-hidden' );

		$notfound.toggleClass( 'is-visible', $items.not( '.is-hidden' ).length == 0 );
	});
})( jQuery, window, document );


// toggling items on title press

;( function( $, window, document, undefined )
{
	$( document ).on( 'click', '.faq h2 a', function( e )
	{
		e.preventDefault();
		$( this ).parents( 'li' ).toggleClass( 'is-active' );
	});
})( jQuery, window, document );


// auto-show item content when show results reduces to single

;( function( $, window, document, undefined )
{
	var $container = $( '.faq' );
	if( !$container.length ) return true;

	var $input		= $container.find( 'input' ),
		$items		= $container.find( '> ul > li' ),
		$item		= $();

	$input.on( 'keyup', function()
	{
		$item = $items.not( '.is-hidden' );
		if( $item.length == 1 )
			$item.addClass( 'js--autoshown is-active' );
		else
			$items.filter( '.js--autoshown' ).removeClass( 'js--autoshown is-active' );
	});
})( jQuery, window, document );
</script>

</body>
</html>