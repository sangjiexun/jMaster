<%@page import="sht.origin.Useful"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--
	BMIを計算するアプリケーションを作成してください。
	また、BMIの結果によって肥満度を表示するようにしてください。
	＜仕様＞
	・BMIは小数点第二位まで表示すること
	・バリデーションチェックを行うこと（空の場合と数値以外の場合）
	・MVCアーキテクチャに基づいて作成すること
	・身長・体重・BMIをプロパティに持つJavaBeansを作成すること
-->
<%
	request.setAttribute("text", "MESSAGE");
	Useful use = new Useful();
	if( !use.isNull(request.getAttribute("isNULL")) ){
		request.setAttribute("mes", "");
	}
	else{
		request.setAttribute("mes", "入力して");
	}
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			td{
				padding: 10px;
			}
		</style>
	</head>
	<body>
		${ isNULL }<br>
		<form action="/jMaster/Ch9No001" method="post">
			<table border="1">
				<tr>
					<td style="width: 100px;">Height</td>
					<td><input type="text" name="H">cm</td>
				</tr>
				<tr>
					<td>Weight</td>
					<td>
						<input type="text" name="W">kg
						<input type="submit" value="計算">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>