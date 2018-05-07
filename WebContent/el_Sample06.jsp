<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%!
	public class PersonBean{
		private String	name;
		private int		age;


		public PersonBean(String name, int age ){
			this.name = name;
			this.age = age;
		}


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
	ArrayList<PersonBean> listStr = new ArrayList<PersonBean>();
	listStr.add( new PersonBean( "田中", 26 ) );
	listStr.add( new PersonBean( "佐藤", 31 ) );
	request.setAttribute( "people", listStr );
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Show_ArrayList</title>
	</head>
	<body>
		<div style="width: 500px;padding: 10px;background: #FFC;">
			<table style="width: 500px; background: #cfc; border: 1px solid #969">
				<tr style="border: 1px solid #969">
					<td style="width:300px; border: 1px solid #969"	>${ people[0].name }</td>
					<td style="border: 1px solid #969"			>${ people[0].age }</td>
				</tr>
				<tr style="border: 1px solid #969">
					<td style="width:300px; border: 1px solid #969"	>${ people[1].name }</td>
					<td style="border: 1px solid #969"			>${ people[1].age }</td>
				</tr>
			</table>
		</div>
	</body>
</html>