<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<script>
	$(function(){
		$("table tbody tr").on("click",function(){
			//console.log("table tbody tr clicked?"+ $(this).data("id"));
			$("#id").val($(this).data("id"));
			$("#frm").submit();
		});
	});
</script>
</head>

<body>

	<%@include file="/common/top.jsp"%>
	<form id="frm" action="/postDetail" method="get">
		<input type="hidden" name="id" id="id" />
		<input type="hidden" name="page" value="${page}"/>
	</form>
	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${board_nm}</h2>
						<div class="table-responsive">
							
							<table class="table table-striped table-hover">
								<tr>
									<thead>
									<td>순번</td>
									<td>게시글 제목</td>
									<td>작성자</td>
									<th>등록일수(yyyy-MM-dd)</th>
									<thead>
								</tr>
								<tbody>
								<c:forEach var="post" items="${postPageList}">
									<tr data-id="${post.post_code}" data-name="${post.post_ttl}">
										<td>${fn:substring(post.post_code,1,4) }</td>
										<td>${post.post_ttl}</td>
										<td>${post.std_id}</td>
										<td><fmt:formatDate value="${post.post_reg_dt}" pattern="yyyy-MM-dd"/></td>
									</tr>
								</c:forEach>
								</tbody>

							</table>
						</div>

						<a href="/posts/postAdd.jsp?board_code=${board_code}&page=${page}&pageSize=10"class="btn btn-default pull-right">새글쓰기</a>

						<div class="text-center">
							<ul class="pagination">
								${pageNavi}
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>