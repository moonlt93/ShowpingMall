<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 확인</title>
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
<table>
<thead>
	<tr> 
		<th>번호</th>
		<th>이름</th>
		<th>설명</th>
		<th>이미지경로</th>
		<th>상세</th>
		<th>색상</th>
		<th>사이즈</th>
		<th>등록일자</th>
		<th>조회수</th>
	</tr>
</thead>

<tbody>
<c:forEach items="${list}" var="list">
	<tr>
		<td>${list.showNo}</td> 
		
		<td>
		<c:url value="/product/click" var="showpping">
		<c:param value="${list.showNo }" name="showNo" />
		<c:param value="${pageNum.num }" name="showNo" />	
		</c:url>
		<a href="${showpping}" ><c:out value="${list.name }"/>
		</a>
		</td> 
		<td>${list.contents}</td> 
		<td>${list.writer}</td> 
		<td>${list.images}</td> 
		<td>${list.detail}</td> 
		<td>${list.color}</td> 
		<td>${list.size}</td> 
		<td>${list.regDate}</td> 
		<td>${list.viewCnt}</td> 
	</tr>


</c:forEach>


</tbody>

</table>

</body>
</html>