<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setAttribute( "date1", "This is sample1" );

	session.setAttribute( "data2", "This is sample2");


%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>イーサン</title>
	</head>
	<body>
		data1は${ data1 }です。
		data2は${ data2 }です。
	</body>
</html>