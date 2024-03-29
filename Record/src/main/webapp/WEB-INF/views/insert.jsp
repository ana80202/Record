<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>record 등록하기</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	<main>
		<h1>기록하기</h1>
		
		<form action = "/insert" method="post">
			<p>제목</p>
			<input type="text" name="recordTitle" required="required">
			
			<p>기록</p>
			<textarea name="recordMemo" style="resize: none; font-size: 18px;" cols="20" rows="5" ></textarea>
			
			<br>
			<button class="insert-btn2">등록하기</button>
		</form>
	</main>

</body>
</html>