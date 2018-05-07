<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title>ERROR</title>
	</head>
	<body>
		<div style="width: 500px; padding: 10px; background: #FFC;">
			<div style="width: 500px; background: #cfc; padding: 10px;">
				<c:if test="${ not empty noneValueMessage }">${ noneValueMessage }</c:if>
				<c:if test="${ not empty illegalValueMessage }">${ illegalValueMessage }</c:if>
			</div>
		</div>
	</body>
</html>