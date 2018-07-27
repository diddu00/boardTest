<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>대덕인재게시판&#8482;</title>

<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/common/common.css" rel="stylesheet">
<!-- jQuery -->
<!-- <script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery-ui.min.js"></script>-->

<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>


<script src="/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">


var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
			}
		}
	})
	
	$('#cancelbutton').click(function(){
		if(confirm("글쓰기를 취소하고 나가시겠습니까?")){
			oEditors.getById["smarteditor"].exec("SET_IR", [""]);
			location.href = "/postList?board_code="+$("#board_code").val()+"&page="+$("#page").val();
		}
	});  
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}

</script>
</head>
<body>
<%@include file="/common/top.jsp" %>
	<div class="container-fluid">
		<div class="row">

		<%@include file="/common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

  <form action="/postAdd" method="get" id="frm" style="text-align: justify;">
	<div class="form-group">
    <label for="exampleInputEmail1">제목</label>
    <input type="text" style="width: 50%;" class="form-control" id="post_ttl" name="post_ttl" placeholder="제목을 입력하세요">
 	</div>
	작성자 <br><label>${studentVo.std_id}</label><br>
	<input type="hidden" id="std_id" name="std_id" value="${studentVo.std_id}">
	<input type="hidden" id="board_code" name="board_code" value="${param.board_code}">
	<input type="hidden" id="page" name="page" value="${param.page}">
	작성일 <br><label><fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd"/></label><br>
	<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"></textarea> 
	<input type="button" id="savebutton" value="저장" />
	<input type="button" id="cancelbutton" value="취소"/>
  </form>
	<form action="/fileUpload" class="form-horizontal" role="form" method="post" enctype="multipart/form-data">
			<input type="file" name="uploadFile"/><br>
	</form>


			</div>
		</div>
	</div>
</body>
</html>