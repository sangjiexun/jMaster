<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String subject;
	int random = (int)( Math.random() * 4 );
	switch(random){
		case 0:
			subject = "プログラミング";
			break;
		case 1:
			subject = "オープンソースDB";
			break;
		case 2:
			subject = "Linux";
			break;
		default:
			subject = "Android開発";
	}
%>
<h2>今月の講座</h2>
<h1><%= subject %></h1>