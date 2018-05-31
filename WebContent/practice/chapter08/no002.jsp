<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--
	JSP内でページスコープとセッションスコープに任意のデータを格納し、
	bodyタグ内でELによってスコープ内のデータを取得してください
-->
<%
	String text = "Page Message";
	session.setAttribute("text", "Session Massage");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%= text %><br>
	${ text }
	</body>
</html>