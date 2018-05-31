<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
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
		<form action="/jMaster/Ch8No003" method="post">
			<table border="1">
				<tr>
					<td style="width: 100px;"><br>　name　<br><br></td>
					<td>　<input type="text" name="name">　</td>
				</tr>
				<tr>
					<td><br>　pass　<br><br></td>
					<td>
						　<input type="password" name="pass">
						<input type="submit" value="登録">&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>