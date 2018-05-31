<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--
	JSP内でリクエストスコープに文字列のデータを格納し、
	bodyタグ内でELによってリクエストスコープ内のデータを取得してください
-->
<% request.setAttribute("text", "MESSAGE"); %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		${ text }
	</body>
</html>