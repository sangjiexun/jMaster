<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--
	■問題２
	スクリプトレットを使用して、「Hello JSP」と5回連続で表示させるJSPを作成してください。
	----------------------------
	JSP：no002
	配置場所：WebContent/practice/chapter7
	----------------------------
-->
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<% for( int i = 0; i < 5; i++ ){%>
			Hello JSP<br>
		<% } %>
	</body>
</html>