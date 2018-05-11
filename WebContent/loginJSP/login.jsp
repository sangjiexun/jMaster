<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>◆ログイン&amp;登録ページ</title>
	</head>
	<body>
		<div  style="background:#FF9; padding: 10px; width: 400px;margin: 0 auto;">
			<form action="/jMaster/AppServlet" method="post" style="text-align: center;">
				<span style="font-size: 18pt;">ログイン</span>
				<table style ="border-spacing: 5px; text-align: left;" class="formTable">
					<tr>
						<td style="width: 150px">ユーザー名</td>
						<td><input type="text" name="userName" placeholder="user_name"></td>
					</tr>
					<tr>
						<td style="width: 150px">パスワード</td>
						<td><input type="password" name="password" placeholder="password"></td>
					</tr>
				</table>
				<br>
				<input type="hidden" name="log" value="in">
				<input type="submit" value="　送信　" class="onMouse">
			</form>
		</div>

		<br>

		<div  style="background:#9F9; padding: 10px; width: 400px;margin: 0 auto;">
			<form action="/jMaster/AppServlet" method="post" style="text-align: center;">
				<span style="font-size: 18pt;">新規ユーザー登録</span>
				<table style ="border-spacing: 5px; text-align: left;" class="formTable">
					<tr>
						<td style="width: 150px">ユーザー名</td>
						<td><input type="text" name="userName" placeholder="user_name"></td>
					</tr>
					<tr>
						<td style="width: 150px">パスワード</td>
						<td><input type="password" name="password" placeholder="password"></td>
					</tr>
				</table>
				<br>
				<input type="hidden" name="log" value="make">
				<input type="submit" value="　送信　" class="onMouse">
			</form>
		</div>
	</body>
</html>