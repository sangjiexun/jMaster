<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// セッションを使えるようにする（新しくセッションを作る訳ではない）
	HttpSession sessionMyPage = request.getSession(false);

	// ログイン情報が無ければ（ログインできていなければ）実行される。
	if( sessionMyPage.getAttribute("ログイン") == null ){
		RequestDispatcher rd = request.getRequestDispatcher("/loginJSP/login.jsp");
		rd.forward(request, response);
	}
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>◆マイページ</title>
	</head>
	<body>
		<div  style="background:#FF9; padding: 10px; width: 400px;margin: 0 auto; text-align: right;">
			<!-- 既にログインしている状態であるにもかかわらずログインした場合、以下を表示する -->
			<span style="color: red; left ">
				<c:if test="${ readyLogin ne null }">${ readyLogin }</c:if>
			</span>


			<table style ="border-spacing: 5px; text-align: left;" class="formTable">
				<tr>
					<td style="width: 150px">ユーザー名</td>
					<td><%= session.getAttribute("userName") %></td>
				</tr>
				<tr>
					<td style="width: 150px">パスワード</td>
					<td><%= session.getAttribute("password") %></td>
				</tr>
			</table>
			<br>
			<form action="/jMaster/AppServlet" method="post">
				マイページ　
				<input type="hidden" name="log" value="out">
				<input type="submit" value="ログアウト">
			</form>
		</div>
	</body>
</html>