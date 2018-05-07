<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>NEWS</title>
	</head>
	<body>
		<table>
			<tr>
				<td colspan="2"><%@ include file="/include/header.html" %></td>
			</tr>
			<tr>
				<td bgcolor="#AFE">
					<jsp:include page="/include/weather.jsp"></jsp:include>
				</td>
				<td bgcolor="#F9F">
					<jsp:include page="/include/subject.jsp"></jsp:include>
				</td>
			</tr>
		</table>
	</body>
</html>