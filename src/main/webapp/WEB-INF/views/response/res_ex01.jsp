<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>res_ex01파일(요청경로 : /response/res_ex01)</h3>
	
	<a href="res_ex02">res_ex02</a>
	<a href="res_ex03">res_ex03</a>
	<a href="res_ex04?id=kkk123">res_ex04</a>
	
	<form action="res_ex05">
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="password" name="pw"><br>
		<input type="submit" value="check">
	</form>
	
</body>
</html>