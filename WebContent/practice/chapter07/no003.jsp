<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<!--
	■問題３
	式（Expression）を使用して、現在の日時を表示するJSPを作成してください。
	----------------------------
	JSP：no003
	配置場所：WebContent/practice/chapter7
	----------------------------
-->
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<% Date date = new Date(); %>
		<%=date.toString() %>
	</body>
</html>