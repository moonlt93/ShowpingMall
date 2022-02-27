<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-sm mb-3">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${root}/">MAIN</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
      	<c:url value="/product/list" var="listLink" ></c:url>
        <a class="nav-link" href="${listLink }">상품목록 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
       
      	<c:url value="/product/write" var="registerLink" ></c:url>
        <a class="nav-link" href="${registerLink}">상품등록</a>
 
      </li>
      <li>
     	 <a href="/product/listPage?num=1"> 글목록(페이지)</a>
       </li>
        <li>
     	 <a href="/member/signup"> 회원가입(페이지)</a>
       </li>
    

<c:if test="${member == null}">
 <li>
  <a href="/member/signin">로그인</a>
 </li>
 <li>
  <a href="/member/signup">회원가입</a>
 </li>
</c:if>
	<c:if test="${member != null}">
		<c:if test="${member.verify == 9}">
 			<li>
  				<a href="${root}/admin/index">관리자 화면</a>
 			</li>
 		</c:if>

 			<li>
  				  ${member.userName}님 환영합니다.
 			</li>
 	 <li>
	 		<a href="${root}/shop/orderList">주문 리스트</a>
	 </li>	
 			
	 <li>
	 		<a href="${root}/shop/cartList">카트리스트</a>
	 </li>			
 <li>
  <a href="/member/signout">로그아웃</a>
 </li>
</c:if>

 
<%--       <li class="nav-item">
		<c:if test="${member != null}"><a class="nav-link" href="/UserInfo/logout">로그아웃 <span class="sr-only">(current)</span></a></c:if>
		<c:if test="${member == null}"><a class="nav-link" href="/UserInfo/GetLogin">로그인 <span class="sr-only">(current)</span></a></c:if>
								 
	</li>
	<li class="nav-item">
	<c:if test="${member == null}">  <a class="nav-link"  href="/UserInfo/Getregister">회원가입 <span class="sr-only">(current)</span></a></c:if>
	</li>
 --%>	

    </ul>
    
   
  </div>
</nav>

</div>