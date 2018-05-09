<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Show All Items.</title>

		<link rel="stylesheet" href="style/showItem.css">
	</head>
	<body style="background: #FFC;">
		<div id="container">
			<jsp:include page="itemForm.jsp"></jsp:include>
			Ver.002

			<table border="1" style="border-spacing: 0;">
				<tr>
					<th>No.</th><th>商品名</th><th>値段</th><th>削除</th>
				</tr>
				<c:forEach items="${ items }" var="item">
					<tr>
						<td>${ item.code }</td>
						<td>${ item.name }</td>
						<td>${ item.price }</td>
						<td style="text-align: center;">
							<a href="/jMaster/ItemServlet?action=delete&code=$item.code }" style="color: red; font-size: 18pt;">×</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>