<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//セッションが無い時、sessionは「null」
	HttpSession sessionMyPage = request.getSession(false);

	// 箱
	String checkLogin = null;

	// ログインできていたら「ログイン出来てるよ」という情報をcheckLoginに入れる。
	if( sessionMyPage.getAttribute("ログイン") != null ) checkLogin = (String)sessionMyPage.getAttribute("ログイン");

	// ログイン情報が無ければ（ログインできていなければ）実行される。
	if( checkLogin == null ){
		RequestDispatcher rd = request.getRequestDispatcher("/loginJSP/login.jsp");
		rd.forward(request, response);
	}
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
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