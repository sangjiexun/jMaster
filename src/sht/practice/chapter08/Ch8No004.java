package sht.practice.chapter08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.origin.Useful;

/**
	本情報を格納するJavaBeansを作成してください
	no004.jspからformで「タイトル」と「価格」をパラメータとしてサーブレットへ渡してください
	サーブレットで受け取ったデータをJavaBeansに格納し、JavaBeansをリクエストパラメータへ格納してください
	リクエストパラメータへ格納後、book.jspへフォワードしてください。
	book.jsp内でELを使用してタイトルと価格を表示させてください
*/
@WebServlet("/Ch8No004")
public class Ch8No004 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Useful use = new Useful();

		String
			title = use.judgeNull( request.getParameter("title") ),
			price = use.judgeNull( request.getParameter("price") );
		///String

		BookBeans bb = new BookBeans(title, price);
		request.setAttribute("bb", bb);

		RequestDispatcher rd = request.getRequestDispatcher("/practice/chapter08/book.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}