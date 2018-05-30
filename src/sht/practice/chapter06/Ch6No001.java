package sht.practice.chapter06;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sht.origin.Useful;

/**
	■問題１
	社員登録プログラムを下記の仕様に基づいて作成してください
	＜仕様＞
	・HTMLのFormで社員名と社員番号をサーブレット１へ送信すること
	・サーブレット１は社員名をリクエストスコープにいれ、サーブレット２に渡すこと
	・サーブレット２は「"社員名"を登録しました。」を表示するHTMLを返すこと

	■問題２
	chapter6の問題１のプログラムに下記機能修正をしてください
	＜機能修正＞
	・サーブレット１は受け取った社員名と社員番号を社員（Employee）というJavaBeansに格納すること
	・サーブレット１はEmployeeをサーブレット２へ渡すこと
	・サーブレット２は「登録が完了しました。」のあとに登録した社員名と社員番号を表示するHTMLを返すこと

	■問題３
	chapter6の問題２のプログラムに下記機能修正をしてください
	＜機能修正＞
	・サーブレット２が返すHTMLからformのあるHTMLへ遷移するリンクを作成すること
	・formから社員名・社員番号を登録したデータがサーブレット２ですべて順番に表示されること
*/
@WebServlet("/Ch6No001")
public class Ch6No001 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Useful use = new Useful();

		/*■問題１*/
		request.setAttribute( "name01", request.getParameter("name") );
		/*■問題１*/

		/*■問題２*/
		String name = use.judgeNull( request.getParameter("name") );
		String numStr = use.judgeNull( request.getParameter("num") );

		int num = 0;
		if( !use.isNull(name) || !use.isNull(numStr) ) {
			name = "ERROR";
		}
		else {
			num= Integer.parseInt( numStr );
		}
		Employee emp = new Employee( name, num );
		request.setAttribute( "emp", emp );
		/*■問題２*/

		/*■■■問題３*/
		HttpSession session = request.getSession(false);
		if( !use.isNull(session) ) session = request.getSession();

		@SuppressWarnings( "unchecked" )
		ArrayList<Employee> empList = (ArrayList<Employee>) session.getAttribute("empList");
		if( !use.isNull( empList ) ) empList = new ArrayList<>();
		empList.add( new Employee( name, num ) );

		session.setAttribute( "empList", empList );
		/*■■■問題３*/

		RequestDispatcher rd = request.getRequestDispatcher("Ch6No002");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}