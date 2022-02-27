<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<meta charset="UTF-8">
<title>Insert title here</title>
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
<u:navbar />
<h1>게시글 작성 </h1>
<form method="post" class="writeForm">

	
	<label>이름</label>
	<input type="text" name="name" /> <br />
	
	<label>제품설명</label>
	<input type="text" name="contents" /> <br />
	
	<label>작성자</label>
	<input type="text" name="writer" /> <br />
	
	<label>상세</label>
	<textarea  cols="50" rows="5" name="detail"></textarea><br />
	
	<label>색상</label>
	<input type="text" name="color" /> <br />
	
	<label>사이즈</label>
	<input type="text" name="size" /> <br />
	
	<label>이미지</label>
	<input type="text" name="images" /> <br />
	
	<button type="submit" >등록</button>



</form>





<script>

var queryString = $("#writeForm").serialize();

$.ajax({
	url:/product/list,
	type: post,
	data: queryString,
	success: function(data){
		$("#writeForm").submit();
		alert("데이터 전송이 성공적으로 이뤄짐.")

	}
})

</script>

</body>
</html>