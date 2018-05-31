<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--
	本情報を格納するJavaBeansを作成してください
	no004.jspからformで「タイトル」と「価格」をパラメータとしてサーブレットへ渡してください
	サーブレットで受け取ったデータをJavaBeansに格納し、JavaBeansをリクエストパラメータへ格納してください
	リクエストパラメータへ格納後、book.jspへフォワードしてください。
	book.jsp内でELを使用してタイトルと価格を表示させてください
-->
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Ch08_No004<br>
		${ bb.getTitle() }<br>
		${ bb.getPrice() }
	</body>
</html>