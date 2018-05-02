<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%!
	int cnt = 0;
	int getCnt(){
		cnt++;
		return cnt;
	}
%>
<%
	String value = request.getParameter("name");
	session.setAttribute( "name", value );
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 		<link rel="stylesheet" href="style/style.css"> -->
		<title>Insert title here</title>
		<style type="text/css">
			p{color:red;}
		</style>
	</head>
	<body>
		<% for( int i = 0; i < 5; i++ ){/* スクリプティング要素は「< % なかみ % >」*/ %>
			あああああああああああああああああああああああああああああああああああああああああああ<br>
		<% } %>
		<br>
		<br>
		<%
			int randam = 10;
			Date date = new Date();
		%>
		さて、<%= randam %>今日は<%= date %>です。
		<br>
		<br>
		<%= getCnt() %>
		<br>
		<br>
		<p>あなたは</p>
		<%
			value = (String) session.getAttribute("name");
			out.print(value);

		%>
		です。
		<%int f = 10;%>
		<%=f %>だよ
	</body>
</html>