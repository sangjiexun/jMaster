package sht.practice.chapter07;

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
	■問題４
	下記仕様の通りにアプリケーションを作成してください。
	<仕様>
	・JSPファイルにてユーザ名・パスワードを入力し、サーブレットへ渡すこと
	・サーブレットで予め用意しておいたユーザ名とパスワードを受け取ったデータと比較して
	合致すればユーザページへ遷移すること
	・ユーザページはJSPとして用意すること
	・ユーザページではユーザの名前を表示すること
	----------------------------
	初期表示JSP：no004
	ユーザページJSP：userpage
	配置場所：WebContent/practice/chapter7
	        ****
	サーブレット名：Ch7No001
	パッケージ名：sht.practice.chapter7
	URLマッピング：/Ch7No001（デフォルト）
	----------------------------
*/
@WebServlet("/Ch7No001")
public class Ch7No001 extends HttpServlet {
	private String[][] userInfo = { { "a", "aaa" }, { "sht", "pass" } };
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Useful use = new Useful();

		String
			name = use.judgeNull( request.getParameter("name") ),
			pass = use.judgeNull( request.getParameter("pass") );
		///String

		for (String[] user : userInfo) {
			if( user[0].equals(name) && user[1].equals(pass) ) {
				HttpSession se = request.getSession(false);
				se.setAttribute("name", name);
				RequestDispatcher rd = request.getRequestDispatcher("/practice/chapter07/userPage.jsp");
				rd.forward(request, response);
				break;
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}