<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<style>
 body { font-family:'맑은 고딕', verdana; padding:0; margin:0; }
 ul { padding:0; margin:0; list-style:none;  }

 div#root { width:90%; margin:0 auto; }
 
 header#header { font-size:60px; padding:20px 0; }
 header#header h1 a { color:#000; font-weight:bold; }
 
 nav#nav { padding:10px; text-align:right; }
 nav#nav ul li { display:inline-block; margin-left:10px; }

 section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:2px solid #eee; }
 section#container::after { content:""; display:block; clear:both; }
 aside { float:left; width:200px; }
 div#container_box { float:right; width:calc(100% - 200px - 20px); }
 
 aside ul li a { display:block; width:100%; padding:10px 0;}
 aside ul li a:hover { background:#eee; }
 
 footer#footer { background:#f9f9f9; padding:20px; }
 footer#footer ul li { display:inline-block; margin-right:10px; }
</style>

<style>
.inputArea { margin:5px 0; }
select { width:150px; }
label { display:inline-block; width:100px; padding:10px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
textarea#gdsDes { width:400px; height:180px; }
</style>
<style>
#container_box table {width:900px; }
#container_box table th{font-size:20px; font-weight:bold;
						 text-align:center; padding:10px; border-bottom:2px solid #666;}
						 
#container_box table tr:hover{ background:#eee; }
#container_box table td{padding: 10px; text-align:center;}
#container_box table img{width: 150px; height:auto; }


</style>
<style>
/*
#container_box table { width:900px; }
#container_box table th { font-size:20px; font-weight:bold;
       text-align:center; padding:10px; border-bottom:2px solid #666; }
#container_box table tr:hover { background:#eee; }
#container_box table td { padding:10px; text-align:center; }
#container_box table img { width:150px; height:auto; }
*/
 div#container_box ul li { border:5px solid #eee; padding:10px 20px; margin-bottom:20px; }
 div#container_box .orderList span { font-size:20px; font-weight:bold; display:inline-block; width:90px; margin-right:10px; }
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
	<header id="header">
		<%@ include file="../include/header.jsp" %>
	</header>
<u:navbar />
<section id="container">
<aside>
	<%@ include file="../include/aside.jsp" %>
</aside>

	<div id="container_box">
	<h2>상품 배송리스트 조회</h2>
	<section id="content">
	<ul class="orderList">
		 <c:forEach items="${orderList}" var="orderList">
		 <li>
		 <div>
		  <p><span>주문번호</span><a href="/admin/shop/orderView?n=${orderList.orderId}">${orderList.orderId}</a></p>
		  <p><span>주문자</span>${orderList.userId}</p>
		  <p><span>수령인</span>${orderList.orderRec}</p>
		  <p><span>주소</span>(${orderList.userAddr1}) ${orderList.userAddr2} ${orderList.userAddr3}</p>
		  <p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${orderList.amount}" /> 원</p> 
		 	<p><span>상태</span>${orderList.delivery}</p>
		 </div>
		 </li>
		 </c:forEach>
	</ul>
	
	</section>
	

	
	</div>
</section>


<footer id="footer">
	<div id="footer_box">
		<%@ include file="../include/footer.jsp" %>
	</div>
</footer>


</div>

<script type="text/javascript">


//컨트롤러에서 데이터 받기
var jsonData = JSON.parse('${category}');
console.log(jsonData);

var cate1Arr = new Array();
var cate1Obj = new Object();

//1차 분류 셀렉트 박스에 삽입할 데이터 준비
for(var i = 0; i < jsonData.length; i++) {

if(jsonData[i].level == "1") {
cate1Obj = new Object();  //초기화
cate1Obj.cateCode = jsonData[i].cateCode;
cate1Obj.cateName = jsonData[i].cateName;
cate1Arr.push(cate1Obj);
}
}

//1차 분류 셀렉트 박스에 데이터 삽입
var cate1Select = $("select.category1")

for(var i = 0; i < cate1Arr.length; i++) {
cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>"
   + cate1Arr[i].cateName + "</option>"); 
}

$(document).on("change", "select.category1", function(){

	 var cate2Arr = new Array();
	 var cate2Obj = new Object();
	 
	 // 2차 분류 셀렉트 박스에 삽입할 데이터 준비
	 for(var i = 0; i < jsonData.length; i++) {
	  
	  if(jsonData[i].level == "2") {
	   cate2Obj = new Object();  //초기화
	   cate2Obj.cateCode = jsonData[i].cateCode;
	   cate2Obj.cateName = jsonData[i].cateName;
	   cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;
	   
	   cate2Arr.push(cate2Obj);
	  }
	 }
	 
	 var cate2Select = $("select.category2");

/*	 for(var i = 0; i < cate2Arr.length; i++) {
	   cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
	        + cate2Arr[i].cateName + "</option>");
	 } 
	*/
	
	 cate2Select.children().remove();

	 $("option:selected", this).each(function(){
	  
	  var selectVal = $(this).val();  
	  cate2Select.append("<option value='" + selectVal + "'>전체</option>");
	  
	  for(var i = 0; i < cate2Arr.length; i++) {
	   if(selectVal == cate2Arr[i].cateCodeRef) {
	    cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
	         + cate2Arr[i].cateName + "</option>");
	   }
	  }
	  
	 });
	 
	 
	 
	});


</script>

</body>
</html>
