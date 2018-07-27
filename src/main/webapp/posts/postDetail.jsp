<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>대덕인재게시판&#8482;</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/common/common.css" rel="stylesheet">
</head>

<body>
	<%@include file="/common/top.jsp" %>
	<div class="container-fluid">
		<div class="row">
		<%@include file="/common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="page-header">
						  <h1>${board_nm}</h1>
						  <h3>${postVo.post_ttl}</h3>
						 	<span style="text-align:left;">작성자 : ${postVo.std_id}&emsp;&emsp;&emsp;</span>
						 	<span style="text-align:right;">작성일 : <fmt:formatDate value="${postVo.post_reg_dt}" pattern="yyyy-MM-dd"/></span>
						</div>
							<div class="row">
								<c:if test="${attachList != null}">
									&emsp;&emsp;첨부파일<br><br>
									<c:forEach items="${attachList}" var="attach">
										&emsp;&emsp;<a href="/attachDownload?attach_code=${attach.attach_code}&post_code=${postVo.post_code}&page=${page}" >${attach.attach_nm}</a><br>
									</c:forEach>
								<hr>
								</c:if>
							</div>
				<form id="frm" class="form-horizontal" role="form" action="/postEdit" method="get">
					<input type="hidden" id="editValue" name="editValue" value="${postVo.post_code}"/>
					<input type="hidden" name="page" value="${page}"/>
					<div rows="10" cols="100" style="width:766px; height:412px;">${postVo.post_ctt}</div>
				</form>
				<form id="frm2" class="form-horizontal" role="form" action="/postEdit" method="post">
					<input type="hidden" name="page" value="${page}"/>
					<input type="hidden" id="deleteValue" name="deleteValue" value="${postVo.post_code}" />
				</form>
				<c:if test="${studentVo.std_id == postVo.std_id}">
					<input type="button" id="edit" class="btn btn-default pull-left" value="수정">
					<input type="button" id="delet" class="btn btn-default pull-left" value="삭제">
				</c:if>
					<a href="#" class="btn btn-default pull-left">답글</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#edit").click(function(){
			$("#frm").submit();
		});
		
		$("#delet").click(function(){
			if(confirm("정말 삭제 하시겠습니까?")){
				$("#frm2").submit();				
			}
		});
		
	});
</script>
</html>