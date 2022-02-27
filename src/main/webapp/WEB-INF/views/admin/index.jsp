<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>



<style>

 body { margin:0; padding:0; font-family:'맑은 고딕', verdana; }
 a { color:#05f; text-decoration:none; }
 a:hover { text-decoration:underline; }
 
 h1, h2, h3, h4, h5, h6 { margin:0; padding:0; }
 ul, lo, li { margin:0; padding:0; list-style:none; }

 /* ---------- */
 
 div#root { width:900px; margin:0 auto; }
 header#header { }
 nav#nav { }
 section#container { }
  section#content { float:right; width:700px; }
  aside#aside { float:left; width:180px; }
  section#container::after { content:""; display:block; clear:both; } 
 footer#footer { background:#eee; padding:20px; }
 
 /* ---------- */
 
 header#header div#header_box { text-align:center; padding:30px 0; }
 header#header div#header_box h1 { font-size:50px; }
 header#header div#header_box h1 a { color:#000; }
 
 nav#nav div#nav_box { font-size:14px; padding:10px; text-align:right; }
 nav#nav div#nav_box li { display:inline-block; margin:0 10px; }
 nav#nav div#nav_box li a { color:#333; }
 
 section#container { }
 
 aside#aside h3 { font-size:22px; margin-bottom:20px; text-align:center; }
 aside#aside li { font-size:16px; text-align:center; }
 aside#aside li a { color:#000; display:block; padding:10px 0; }
 aside#aside li a:hover { text-decoration:none; background:#eee; }
 
 aside#aside li { position:relative; }
aside#aside li:hover { background:#eee; }   
aside#aside li > ul.low { display:none; position:absolute; top:0; left:180px;  }
aside#aside li:hover > ul.low { display:block; }
aside#aside li:hover > ul.low li a { background:#eee; border:1px solid #eee; }
aside#aside li:hover > ul.low li a:hover { background:#fff;}
aside#aside li > ul.low li { width:180px; }
 
 footer#footer { margin-top:100px; border-radius:50px 50px 0 0; }
 footer#footer div#footer_box { padding:0 20px; }
 
</style>
	<title>Home</title>
</head>

<link href="jquery-ui.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>


<body>
<div id="root">
<u:navbar />
<section id="container">
<aside>
	<%@ include file="include/aside.jsp" %>
</aside>

	<div id="container_box">
		본문영역
	</div>
</section>
<footer id="footer">
	<div id="footer_box">
		<%@ include file="../include/footer.jsp" %>
	</div>
</footer>

</div>

</body>
</html>
