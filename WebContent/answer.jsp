<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "sht.beans.PlusBean" %>
<%
	PlusBean bean = (PlusBean)request.getAttribute( "plus" );
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>アンサー</title>
	</head>
	<body>
		いくぞ！！_v02
		${ bean.getValue1() }
		+
		${ bean.getValue2() }
		=
		${ bean.getAnswer() }
	</body>
</html>