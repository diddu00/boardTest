<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>대덕인재게시판</title>

<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<%@include file="/common/jquery.jsp" %>
<script>
	$(function(){
		$("#createBtn").click(function(){
			if($("#newboard").val()==""){
				alert("게시판 이름을 입력하세요.");
				$("#newboard").focuse();
				return;
			}
			$("#frm").submit();
		});
		
	});

</script>
</head>

<body>

   <!-- top -->
   <%@ include file="/common/top.jsp"%>

   <div class="container-fluid">
      <div class="row">

         <!-- left -->
         <%@ include file="/common/left.jsp"%>

         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="blog-header">
               <h3 class="blog-title">게시판 editor</h3>
            </div>

            <div class="row">

               <div class="col-sm-8 blog-main">
                  <div class="blog-post">
                     <h2 class="blog-post-title">게시판을 수정할 건가요!?</h2>
                       <hr>
                       <form id="frm" action="/boardAdd" method="post">
              		     	 게시판 생성 <input type="text" id="newboard" name="newboard">
              		     	 <select name="boardUse"> 
	                        	<option value="true">사용</option>
	                        	<option value="false">미사용</option>
	                     	</select>
                     		<input type="button" id="createBtn" name="createBtn" value="생성"/> <br>
                       </form>
                     <hr>
                     <c:forEach items="${boardAllList}" var="board">
                     	<form action="/boardAdd" method="get">
	                     <hr>
	                  	   게시판 이름<input type="text" value="${board.board_nm}" readonly/>
	                  	   		  <input type="hidden" name="board_code" value="${board.board_code}"/>
	                     	<select name="boardUse"> 
	                        <option value="true" <c:if test="${board.board_use eq 'true'}">selected</c:if>>사용</option>
	                        <option value="false" <c:if test="${board.board_use eq 'false'}">selected</c:if>>미사용</option>
	                     	</select>
	                     	 <input type="submit" value="수정"/>
	                     <hr>
                     	</form>
	                  </c:forEach>
                    
                  </div>
               </div>
               <!-- /.blog-main -->
            </div>
         </div>
      </div>
   </div>
</body>
</html>