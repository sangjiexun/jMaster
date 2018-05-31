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
		<form action="/jMaster/Ch8No004" method="post">
			<table border="1">
				<tr>
					<td style="width: 100px;"><br>&nbsp;&nbsp;&nbsp;Title&nbsp;&nbsp;&nbsp;<br><br></td>
					<td>&nbsp;&nbsp;&nbsp;<input type="text" name="title">&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td><br>&nbsp;&nbsp;&nbsp; Price &nbsp;&nbsp;&nbsp;<br><br></td>
					<td>
						&nbsp;&nbsp;&nbsp;<input type="text" name="price">
						<input type="submit" value="登録">&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>