package sht.practice.chapter09;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.origin.Useful;

/**
	BMIを計算するアプリケーションを作成してください。
	また、BMIの結果によって肥満度を表示するようにしてください。
	＜仕様＞
	・BMIは小数点第二位まで表示すること
	・バリデーションチェックを行うこと（空の場合と数値以外の場合）
	・MVCアーキテクチャに基づいて作成すること
	・身長・体重・BMIをプロパティに持つJavaBeansを作成すること
*/
@WebServlet("/Ch9No001")
public class Ch9No001 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Useful use = new Useful();

		int
			H = use.judgeInt( request.getParameter("H") ),
			W = use.judgeInt( request.getParameter("W") );
		///int

		// 未入力の場合
		if( H == 0 || W == 0 ) {
			request.setAttribute("isNULL", "");
			RequestDispatcher rd = request.getRequestDispatcher("/practice/chapter09/no001.jsp");
			rd.forward(request, response);
			return;
		}
		// 入力ありの場合
		else {
			Ch9No002 cn92 = new Ch9No002();
			double douBMI = cn92.calcBMI(H, W);

			BMIBeans bb = new BMIBeans(H, W, douBMI);
			request.setAttribute("bb", bb);

			String rank = cn92.judgeRank(douBMI);

			request.setAttribute("rank", rank);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/practice/chapter09/no002.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}