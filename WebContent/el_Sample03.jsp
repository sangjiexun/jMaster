<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	public class PersonBean{
		private String name;
		private int age;


		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}


		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}
%>
<%
	PersonBean bean = new PersonBean();
	bean.setName( "田中" );
	bean.setAge(30);
	request.setAttribute( "person", bean );
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		${ person.name }です<br>
		${ person.age }です
	</body>
</html>