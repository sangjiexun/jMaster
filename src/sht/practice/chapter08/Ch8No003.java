package sht.practice.chapter08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sht.origin.Useful;

/**
	no003.jspからformで「名前」と「パスワード」をパラメータとしてサーブレットへ渡してください
	「名前」パラメータをセッションスコープに格納し、name.jspにフォワードしてください
	name.jsp内でELを使用して名前を取得して表示させてください
*/
@WebServlet("/Ch8No003")
public class Ch8No003 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Useful use = new Useful();

		String
			name = use.judgeNull( request.getParameter("name") )/*,
			pass = use.judgeNull( request.getParameter("pass") )*/;
		///String

		HttpSession se = request.getSession(false);
		se.setAttribute("name", name);
		RequestDispatcher rd = request.getRequestDispatcher("/practice/chapter08/name.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}