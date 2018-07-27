<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>

<body>
	<%@include file="/common/top.jsp"%>
	<!-- top.jsp -->
	<div class="container-fluid">
		<div class="row">
		<%@include file="/common/left.jsp" %>
		<!-- left.jsp -->
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="blog-header">
					<h1 class="blog-title">삭제된 글입니다.</h1>
					<p class="lead blog-description">이 글을 작성한 작성자가 삭제를 하였습니다.</p>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">
							<h2 class="blog-post-title">대덕인재게시판</h2>
							<p class="blog-post-meta">2018.02.28, room 207</p>

							<p>삭제된 글내역입니다.</p>
							<hr>

							<h3>상세내역</h3>
							<p>글이 삭제되어 접근이 불가합니다.</p>
							<ul>
								<li>글에 대한 내역을 검색할 수 없습니다.</li>
								<li>글의 내용을 복구하려면 관리자에게 문의하세요</li>
							</ul>
							<a href="/postList?page=${page}&pageSize=10&board_code=${postVo.board_code}" class="btn btn-default pull-left">뒤로가기</a>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>