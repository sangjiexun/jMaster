<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
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
	HashMap< String, String > mapStr = new HashMap< String, String >();
	mapStr.put( "田中", "111" );
	mapStr.put( "佐藤", "222" );
	mapStr.put( "山田", "333" );
	session.setAttribute( "tel", mapStr );
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Show_ArrayList</title>
	</head>
	<body>
		<div style="width: 500px;padding: 10px;background: #FFC;">
			<table style="background: #cfc; border: 1px solid #969">
				<tr>
					<td style="width:300px; border: 1px solid #969"	>たなか</td>
					<td style="border: 1px solid #969"			>${ tel.田中 }</td>
				</tr>
				<tr>
					<td style="width:300px; border: 1px solid #969"	>さとう</td>
					<td style="border: 1px solid #969"			>${ tel.佐藤 }</td>
				</tr>
				<tr>
					<td style="width:300px; border: 1px solid #969"	>やまだ</td>
					<td style="border: 1px solid #969"			>${ tel.山田 }</td>
				</tr>
			</table>
		</div>
	</body>
</html>