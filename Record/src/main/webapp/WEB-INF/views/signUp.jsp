<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Record 회원가입</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	<main>
		<h1 class ="signlogo">회원가입</h1>
		
		<form action= "/signUp" method="post" class="signup-form" onsubmit="return validate()">
			<p>아이디</p>
			<input type="text" name="inputId" id="inputId" autocomplete="off" required="required"  class= "bottom-b">
			 <!--autocomplete="off": 자동완성 끄기  -->
			 
			 <span id="idMsg">영어 소문자, 숫자, 특수문자 포함 6~ 14글자 </span>
			 
			 <p>비밀번호</p>
			 <input type="password" name="inputPw" id="inputPw" required="required"  class= "bottom-b">

			 <p>비밀번호 확인</p>
			 <input type="password" name="inputPw2" id="inputPw2" required="required"  class= "bottom-b">
			 <span id="pwMessage"></span>
			 
			 <p>닉네임</p>
			 <input type="text" name="inputName" id="inputName" required="required"	  class= "bottom-b">	
			 <span id="nameMessage"></span>
			 <br>
			 
			 <button>가입하기</button>
			 </form>
	</main>
	
	<%--해당 jsp 파일에서 사용할 javascript 코드가 작성된 js 파일 연결하기 --%>
	<script src="/resources/js/signup.js"></script>
	

</body>
</html>