<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="${currentPage =='main'?'active':'' }"><a href="/main">Main <span class="sr-only"></span></a></li>
		<li class="${currentPage =='boardCreate'?'active':'' }"><a href="/boardCreate">게시판생성</a></li>
		<c:forEach items="${useBoardList}" var="useboard">
			<li class="${currentPage ==useboard.board_code?'active':'' }"><a href="/postList?page=1&pageSize=10&board_code=${useboard.board_code}">${useboard.board_nm}</a></li>
		</c:forEach>
	</ul>
</div>
