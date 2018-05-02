<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%
	String arrayStr[] = {"one", "two", "three"};
	session.setAttribute( "data", arrayStr );

	ArrayList<String> listStr = new ArrayList<String>();
	listStr.add("ten");
	listStr.add("handred");
	listStr.add("thousand");
	session.setAttribute( "dataList", listStr );
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		${ data[0] }<br>
		${ data[1] }<br>
		${ data[2] }<br>
		<br>
		${ dataList[0] }<br>
		${ dataList[1] }<br>
		${ dataList[2] }<br>
	</body>
</html>