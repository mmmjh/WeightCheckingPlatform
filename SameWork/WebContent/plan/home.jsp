<%@page import="com.jaovo.msg.model.Namenum"%>
<%@page import="com.jaovo.msg.Util.WordDaoImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Paper &mdash; Free Website Template, Free HTML5 Template by freehtml5.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by freehtml5.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Josefin+Slab:400,600,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Sacramento" rel="stylesheet">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/icomoon.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/magnific-popup.css">
	<link rel="stylesheet" href="css/flexslider.css">
	<link rel="stylesheet" href="css/style.css">
	<script src="js/modernizr-2.6.2.min.js"></script>
	<script src='https://cdn.bootcss.com/echarts/3.7.0/echarts.simple.js'></script>
   <script src="../echarts-all.js"></script>
 <style>
@import url("http://fonts.googleapis.com/css?family=Open+Sans:400,600,700");
@import url("http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css");
*, *:before, *:after {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html, body {
  height: 100%;
}

body {
  font: 14px/1 'Open Sans', sans-serif;
  color: #555;
  background: #eee;
}

h1 {
  padding: 50px 0;
  font-weight: 400;
  text-align: center;
}

p {
  margin: 0 0 20px;
  line-height: 1.5;
}

main {
  min-width: 1500px;
  max-width: 1500px;
  padding: 50px;
  margin: 0 auto;
  margin-top:-180px;
   margin-left:-40px;
  background: #fff;
}

section {
  display: none;
  padding: 20px 0 0;
  border-top: 1px solid #ddd;
}

input {
  display: none;
}

label {
  display: inline-block;
  margin: 0 0 -1px;
  padding: 15px 25px;
  font-weight: 600;
  text-align: center;
  color: #bbb;
  border: 1px solid transparent;
}

label:before {
  font-family: fontawesome;
  font-weight: normal;
  margin-right: 10px;
}

label[for*='1']:before {
  content: '\f1cb';
}

label[for*='2']:before {
  content: '\f17d';
}

label[for*='3']:before {
  content: '\f16b';
}

label[for*='4']:before {
  content: '\f1a9';
}

label:hover {
  color: #888;
  cursor: pointer;
}

input:checked + label {
  color: #555;
  border: 1px solid #ddd;
  border-top: 2px solid orange;
  border-bottom: 1px solid #fff;
}

#tab1:checked ~ #content1,
#tab2:checked ~ #content2,
#tab3:checked ~ #content3,
#tab4:checked ~ #content4 {
  display: block;
}

@media screen and (max-width: 650px) {
  label {
    font-size: 0;
  }

  label:before {
    margin: 0;
    font-size: 18px;
  }
}
@media screen and (max-width: 400px) {
  label {
    padding: 15px;
  }
}

</style>

    <script src="js/prefixfree.min.js"></script>
	</head>
	<%
	    WordDaoImpl namenumImp=new WordDaoImpl();       				
		List<Namenum> lists1=namenumImp.search1();
		List<Namenum> lists2=namenumImp.search2();
		List<Namenum> lists3=namenumImp.search3();
		List<Namenum> lists4=namenumImp.search4();
		String []str1=new String[]{"信息化热词","大数据","物联网","云计算","区块链","智慧城市","工业互联网"};
		String []str2=new String[]{"信息安全","计算机病毒的防范","黑客与入侵检测","信息系统测评"};
		String []str3=new String[]{"计算机基础","操作系统","数据库","计算机网络"};
		String []str4=new String[]{"国家信息战略规划","信息安全相关的法律法规"};
		
		%>
	<body>
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="container-fluid">
			<div class="row">
				<div class="top-menu">
					<div class="container">
						<div class="row">
							<div class="col-sm-7 text-left menu-1">
								<ul>								
									<li class="active"><a href="#">热词搜索</a></li>
									<li><a href="#">热词解释</a></li>
									<li><a href="../input/Keyword.jsp">关键字、摘要</a></li>
									
								</ul>
							</div>
							<div class="col-sm-5">
								<ul class="fh5co-social-icons">
									<li><a href="#"><i class="icon-twitter-with-circle"></i></a></li>
									<li><a href="#"><i class="icon-facebook-with-circle"></i></a></li>
									<li><a href="#"><i class="icon-linkedin-with-circle"></i></a></li>
									<li><a href="#"><i class="icon-dribbble-with-circle"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
						
	</nav>
	<div style="text-align:center;clear:both">
	<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
	<script src="/follow.js" type="text/javascript"></script>
	</div>
	<main>
	  <button onclick="window.location.href='./download.jsp'" class="btn btn-primary" style="margin-left:1300px" value="下载">下载</button>
  <center>

  <input id="tab1" type="radio" name="tabs" checked>
  <label for="tab1">新技术领域热词</label>

  <input id="tab2" type="radio" name="tabs">
  <label for="tab2">网络领域热词</label>

  <input id="tab3" type="radio" name="tabs">
  <label for="tab3">信息化热词</label>
  
  <input id="tab4" type="radio" name="tabs">
  <label for="tab4">信息化政策领域热词</label>
  
  <section id="content1">
   <div id="fh5co-content" class="fh5co-no-pd-top">
		<div class="container">			
			<div class="row">
				<aside id="sidebar">
					<div class="col-md-3">							
						<div class="side animate-box">
						<br><br>
							<div class="col-md-12 col-md-offset-0 text-center fh5co-heading fh5co-heading-sidebar">
								<h2><span>新技术领域</span></h2>
							</div>
							<ul class="category">
							<%
							for(int i=0;i<str1.length;i++){
							%>
								<li><a href="#?name=<%=str1[i]%>"><i class="icon-check"></i><%=str1[i] %></a></li>
							<%} %>
							</ul>
						</div>						
					</div>
				</aside>
				<div class="col-md-6 field">
						 <div id="main" style="height:700px;width:1000px"></div>
				</div>						
			</div>									
		</div>
	</div>
  </section>

  <section id="content2">
    <p>
    <div id="fh5co-content" class="fh5co-no-pd-top">
		<div class="container">			
			<div class="row">
				<aside id="sidebar">
					<div class="col-md-3">							
						<div class="side animate-box">
						<br><br>
							<div class="col-md-12 col-md-offset-0 text-center fh5co-heading fh5co-heading-sidebar">
								<h2><span>网络安全领域</span></h2>
							</div>
							<ul class="category">
							<%
							for(int i=0;i<str2.length;i++){
							%>
								<li><a href="#?name=<%=str2[i]%>"><i class="icon-check"></i><%=str2[i] %></a></li>
							<%} %>
							</ul>
						</div>						
					</div>
				</aside>
				<div class="col-md-6 field">
						 <div id="main2" style="height:700px;width: 1000px"></div>
				</div>						
			</div>									
		</div>
	</div>
  </section>
  
  

  <section id="content3">
    <div id="fh5co-content" class="fh5co-no-pd-top">
		<div class="container">			
			<div class="row">
				<aside id="sidebar">
					<div class="col-md-3">							
						<div class="side animate-box">
						<br><br>
							<div class="col-md-12 col-md-offset-0 text-center fh5co-heading fh5co-heading-sidebar">
								<h2><span>信息领域</span></h2>
							</div>
							<ul class="category">
							<%
							for(int i=0;i<str3.length;i++){
							%>
								<li><a href="#?name=<%=str3[i]%>"><i class="icon-check"></i><%=str3[i] %></a></li>
							<%} %>
							</ul>
						</div>						
					</div>
				</aside>
				<div class="col-md-6 field">
						 <div id="main3" style="height:700px;width: 1000px"></div>
				</div>						
			</div>									
		</div>
	</div>
  </section>
  
    <section id="content4">
    <p>
    <div id="fh5co-content" class="fh5co-no-pd-top">
		<div class="container">			
			<div class="row">
				<aside id="sidebar">
					<div class="col-md-3">							
						<div class="side animate-box">
						<br><br>
							<div class="col-md-12 col-md-offset-0 text-center fh5co-heading fh5co-heading-sidebar">
								<h2><span>信息化政策</span></h2>
							</div>
							<ul class="category">
							<%
							for(int i=0;i<str4.length;i++){
							%>
								<li><a href="#?name=<%=str4[i]%>"><i class="icon-check"></i><%=str4[i] %></a></li>
							<%} %>
							</ul>
						</div>						
					</div>
				</aside>
				<div class="col-md-6 field">
						 <div id="main4" style="height:700px;width: 1000px"></div>
				</div>						
			</div>									
		</div>
	</div>
  </section>
  
  </center>
</main>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>
 <script type="text/javascript">
  function createRandomItemStyle() {
	    return {
	        normal: {
	            color: 'rgb(' + [
	                Math.round(Math.random() * 160),
	                Math.round(Math.random() * 160),
	                Math.round(Math.random() * 160)
	            ].join(',') + ')'
	        }
	    };
	}

        // 基于准备好的dom，初始化echarts图表
        var chart = echarts.init(document.getElementById('main')); 
        var option = {
        	    title: {
        	        text: '近期新技术领域热词',
        	        link: ''
        	    },
        	    tooltip: {
        	        show: true
        	    },
        	    series: [{
        	        name: '近期AI热词',
        	        type: 'wordCloud',
        	        size: ['100%', '100%'],
        	        gridSize: 1,
                    sizeRange: [12, 50],
                    rotationRange: [-90, 90],
        	        shape: 'pentagon',
        	        width: 600,
                    height: 400,
        	        drawOutOfBound: true,
        	        emphasis: {
                        shadowBlur: 10,
                        shadowColor: '#333'
                    },
                    data: [      			
     	               <%    
     				for(int i=0;i<lists1.size();i++){   					
     				%>
     				 {
     					 name: '<%=""+lists1.get(i).getName()+""%>',
     	                value: <%=12*100%>, 
     	                itemStyle: createRandomItemStyle()        	               
     	            },
     	        	<%
     				}		
     	        	%>
     	        ]
        	    }]
        	};
       
        // 为echarts对象加载数据 
        chart.setOption(option); 
        window.onresize = chart.resize;
        
        var chart = echarts.init(document.getElementById('main4')); 
        var option = {
        	    title: {
        	        text: '近期国家信息化政策规划热词',
        	        link: ''
        	    },
        	    tooltip: {
        	        show: true
        	    },
        	    series: [{
        	        name: '政策热词',
        	        type: 'wordCloud',
        	        size: ['100%', '100%'],
        	        gridSize: 1,
                    sizeRange: [12, 50],
                    rotationRange: [-90, 90],
        	        shape: 'pentagon',
        	        width: 600,
                    height: 400,
        	        drawOutOfBound: true,
        	        emphasis: {
                        shadowBlur: 10,
                        shadowColor: '#333'
                    },
                    data: [      			
      	               <%    
      				for(int i=0;i<lists4.size();i++){
      					
      				%>
      				 {
      					 name: '<%=""+lists4.get(i).getName()+""%>',
      	                value: <%=12*100%>, 
      	                itemStyle: createRandomItemStyle()        	               
      	            },
      	        	<%
      				}	for(int i=0;i<lists4.size();i++){
      					
      				%>
      				 {
      					 name: '<%=""+lists4.get(i).getName1()+""%>',
      	                value: <%=12*100%>, 
      	                itemStyle: createRandomItemStyle()        	               
      	            },
      	        	<%
      				}for(int i=0;i<lists4.size();i++){
      					
      				%>
      				 {
      					 name: '<%=""+lists4.get(i).getName2()+""%>',
      	                value: <%=12*100%>, 
      	                itemStyle: createRandomItemStyle()        	               
      	            },
      	        	<%
      				}
      	        	%>
      	        ]
        	    }]
        	};
       
        // 为echarts对象加载数据 
        chart.setOption(option); 
        window.onresize = chart.resize;
        
        var chart2 = echarts.init(document.getElementById('main2')); 
        var option2 = {
        	    title: {
        	        text: '近期网络安全领域热词',
        	        link: ''
        	    },
        	    tooltip: {
        	        show: true
        	    },
        	    series: [{
        	        name: '近期大数据热词',
        	        type: 'wordCloud',
        	        size: ['100%', '100%'],
        	        gridSize: 1,
                    sizeRange: [12, 50],
                    rotationRange: [-90, 90],
        	        shape: 'pentagon',
        	        width: 600,
                    height: 400,
        	        drawOutOfBound: true,
        	        emphasis: {
                        shadowBlur: 10,
                        shadowColor: '#333'
                    },
                   
                    data: [      			
     	               <%    
     				for(int i=0;i<lists2.size();i++){
     					
     				%>
     				 {
     					 name: '<%=""+lists2.get(i).getName()+""%>',
     	                value: <%=12*100%>, 
     	                itemStyle: createRandomItemStyle()        	               
     	            },
     	        	<%
     				}	for(int i=0;i<lists2.size();i++){
     					
     				%>
     				 {
     					 name: '<%=""+lists2.get(i).getName1()+""%>',
     	                value: <%=12*100%>, 
     	                itemStyle: createRandomItemStyle()        	               
     	            },
     	        	<%
     				}for(int i=0;i<lists2.size();i++){
     					
     				%>
     				 {
     					 name: '<%=""+lists2.get(i).getName2()+""%>',
     	                value: <%=12*100%>, 
     	                itemStyle: createRandomItemStyle()        	               
     	            },
     	        	<%
     				}
     	        	%>
     	        ]
        	    }]
        	};
       
        // 为echarts对象加载数据 
        chart2.setOption(option2); 
        window.onresize = chart2.resize;
        
        var chart3 = echarts.init(document.getElementById('main3')); 
        var option3= {
        	    title: {
        	        text: '近期信息基础热词',
        	        link: ''
        	    },
        	    tooltip: {
        	        show: true
        	    },
        	    series: [{
        	        name: '近期信息基础热词',
        	        type: 'wordCloud',
        	        size: ['100%', '100%'],
        	        gridSize: 1,
                    sizeRange: [12, 50],
                    rotationRange: [-90, 90],
        	        shape: 'pentagon',
        	        width: 600,
                    height: 400,
        	        drawOutOfBound: true,
        	        emphasis: {
                        shadowBlur: 10,
                        shadowColor: '#333'
                    },
                   
        	        data: [      			
        	               <%    
        				for(int i=0;i<lists3.size();i++){
        					
        				%>
        				 {
        					 name: '<%=""+lists3.get(i).getName()+""%>',
        	                value: <%=12*100%>, 
        	                itemStyle: createRandomItemStyle()        	               
        	            },
        	        	<%
        				}	for(int i=0;i<lists3.size();i++){
        					
        				%>
        				 {
        					 name: '<%=""+lists3.get(i).getName1()+""%>',
        	                value: <%=12*100%>, 
        	                itemStyle: createRandomItemStyle()        	               
        	            },
        	        	<%
        				}for(int i=0;i<lists3.size();i++){
        					
        				%>
        				 {
        					 name: '<%=""+lists3.get(i).getName2()+""%>',
        	                value: <%=12*100%>, 
        	                itemStyle: createRandomItemStyle()        	               
        	            },
        	        	<%
        				}
        	        	%>
        	        ]
        	    }]
        	};
       
        // 为echarts对象加载数据 
        chart3.setOption(option3); 
        window.onresize = chart3.resize;
        
        chart.on("click", function (param){  
      	  var name=param.name;
      	window.location.href="text.jsp?name="+name;
      });
        chart2.on("click", function (param){  
        	  var name=param.name;
        	window.location.href="text.jsp?name="+name;
        });
        chart3.on("click", function (param){  
        	  var name=param.name;
        	window.location.href="text.jsp?name="+name;
        });
        chart4.on("click", function (param){  
      	  var name=param.name;
      	window.location.href="text.jsp?name="+name;
      });
    </script>
	</body>
</html>

