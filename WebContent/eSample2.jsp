<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute( "value1", "This is aaaasample1" );
	application.setAttribute( "value2", "This is aaaaaaasample2");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>サン</title>
	</head>
	<body>
		data1は${ pageScope.value1 }です。<br>
		data2は${ requestScope.value2 }です。
	</body>
</html>