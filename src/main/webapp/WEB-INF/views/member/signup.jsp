<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<%@ page session="false" %>
<html>
<head>
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
<u:navbar />
<div class="container">

<section id="content">
 <form role="form" method="post" autocomplete="off">
  <div class="input_area">
   <label for="userId">아이디</label>
   <input type="email" id="userId" name="userId" placeholder="example@email.com" required="required" />      
  </div>
  
  <div class="input_area">
   <label for="userPass">패스워드</label>
   <input type="password" id="userPass" name="userPass" required="required" />      
  </div>
  
  <div class="input_area">
   <label for="userName">닉네임</label>
   <input type="text" id="userName" name="userName" placeholder="닉네임을 입력해주세요" required="required" />      
  </div>
  
  <div class="input_area">
   <label for="userPhon">연락처</label>
   <input type="text" id="userPhone" name="userPhone" placeholder="연락처를 입력해주세요" required="required" />      
  </div>
  
  <button type="submit" id="signup_btn" name="signup_btn">회원가입</button>
  
 </form>   
</section>
</div>

</body>
</html>
