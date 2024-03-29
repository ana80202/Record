<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기록 수정하기</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	

	<main>
		<h1>수정</h1>
		
		<form action = "/update?recordNo=${ dayrecord.recordNo }" method="post">
			<p>제목</p>
			<input class="conbox" type="text" name="recordTitle" value="${ dayrecord. recordTitle}" required="required">
			
			<p>메모</p>
			<textarea name="recordMemo" style="resize: none; font-size: 18px;" cols="20" rows="5" >${dayRecord.recordMemo}</textarea>
			
			<input  class="conbox" name="recordNo" value="${ dayrecord.recordNo}" type="hidden" >  
			
			<br>
			<button class="insert-btn1">수정하기</button>
		</form>
	</main>


</body>
</html>