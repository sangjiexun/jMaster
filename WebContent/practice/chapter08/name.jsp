<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--
	no003.jspからformで「名前」と「パスワード」をパラメータとしてサーブレットへ渡してください
	「名前」パラメータをセッションスコープに格納し、name.jspにフォワードしてください
	name.jsp内でELを使用して名前を取得して表示させてください
-->
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Ch08_No001<br>
		${ name }
	</body>
</html>