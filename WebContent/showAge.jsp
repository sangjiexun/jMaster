<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ShowAge</title>
	</head>
	<body>
		<div style="width: 500px; padding: 10px; background: #FFC;">
			<div style="max-width: 500px; background: #cfc; padding: 10px;">
				<c:if test="${ not empty person.name }">
					${ person.name }は
				</c:if>
				<span style = "font-size: 24pt;">${ person.age }歳</span>です。
			</div>
		</div>
	</body>
</html>