package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.beans.PlusBean;

@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();


		out.println( "答え合わせ<br>答え合わせ<br>答え合わせ<br><br>" );


		// リクエストスコープにデータ格納
//		Integer num01 = (Integer)request.getAttribute( "data1" );
//		Integer num02 = (Integer)request.getAttribute( "data2" );
//		Integer answer = (Integer)request.getAttribute( "answer" );
//		out.println( num01 + " + " + num02 + " = " + answer + "<br><br>" );


		// 豆から出す
		sht.beans.PlusBean bean = (PlusBean)request.getAttribute( "plus" );
		out.println( bean.getValue1() + " + " + bean.getValue2() + " = " + bean.getAnswer() + "<br><br>" );
	}
}