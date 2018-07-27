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

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!-- <script src="../../assets/js/ie-emulation-modes-warning.js"></script> -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
     <%@ include file = "/common/jquery.jsp" %>
    <script >
    	function getCookie(name){
    		var cookies = document.cookie;
    		
    		var cookieArr = cookies.split("; ");
	    	var cookieResult = "";
    		
	    	for(var i in cookieArr){
	    		var cookie = cookieArr[i];
	    		var cookieNameValue = cookie.split("=");
	    		
	    		var cookieName = cookieNameValue[0];
	    		var cookieValue = cookieNameValue[1];
	    		
	    		if(name == cookieName){
	    			cookieResult = cookieValue;
	    			break;
	    		}
	    	}
	    	
	    	return cookieResult;
    		    		
    	}
    	
    	function setCookie(cookieName, cookieValue, expires){
    		var dt = new Date();
    		dt.setDate(dt.getDate()+parseInt(expires));
    		document.cookie = cookieName +"="+cookieValue+"; path=/; expires="+dt.toGMTString();
    	}
    	
    	function deleteCookie  (cookieName){
    		setCookie(cookieName,"",-1);
    	}
    	
    	$(function(){
    		if(getCookie("remember")=="y"){
	    		//userId input에 userId cookie 값을 설정
	    		$("#inputID").val(getCookie("ID"));
	    		$("#rememberMe").attr("checked",true);
	    		$("#rememberMe").val(getCookie("remember"));
	    		//=document.getElementById("userId").value = getCookie("userId");
	    	}
    
    		$("#loginBtn").click(function(){
    			if($("#inputID").val()==null){
    				alert("아이디를 입력하세요.");
    				return;
    			}
    			
    			if($("#inputPassword").val()==null){
    				alert("비밀번호를 입력하세요.");
    				return;
    			}
    			
    			if($("#rememberMe").is(":checked")){
    				//rememberMe 쿠키 설정
    				setCookie("ID",$("#inputID").val(),30);
    				setCookie("remember","y",30);
    			}else{
    				//쿠키 제거 
    				deleteCookie("remember");
    			}
    			
    			$("#frm").submit();
    		});
    		
    		
    	});
    </script>
  </head>

  <body>

    <div class="container">

      <form id="frm" action="/login" class="form-signin" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">ID</label>
        <input type="text" id="inputID" name="id" class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name=password class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input id="rememberMe" name="rememberMe" type="checkbox"> Remember me
          </label>
        </div>
        <button id="loginBtn" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
