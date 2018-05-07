<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- プレフィックスは何でもいい（基本はｃ） -->

<%
	request.setAttribute( "age", "35" );
	request.setAttribute( "age", "19" );

	int num = (int)( Math.random() * 4 );
	request.setAttribute( "luck", new Integer(num) );
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL</title>
	</head>
	<body>
		<div style="width: 500px;padding: 10px;background: #FFC;">
			<div style="background: #cfc; padding: 10px;">
				<!-- 条件文 -->
				<c:if test="${ age ge 20 }">成人</c:if>
				<c:if test="${ age lt 20 }">未成年</c:if>


				<br>


				<!-- 条件分岐（複数） -->
				<c:choose>
					<c:when test="${ luck eq 0 }"	>大吉</c:when>
					<c:when test="${ luck eq 1 }"	>吉</c:when>
					<c:when test="${ luck eq 2 }"	>凶</c:when>
					<c:otherwise				>F5だ！</c:otherwise>
				</c:choose>
			</div>
		</div>
	</body>
</html>