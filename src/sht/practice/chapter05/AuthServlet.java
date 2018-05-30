package sht.practice.chapter05;

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
■問題１
名前とパスワードでログインするアプリケーションを作成してください。
>>>仕様
・ログインに成功した際にセッションを生成し、名前をセッション情報に格納すること
・ログイン成功後はログインした名前を表示すること
■問題２
問題１で作成したindex.htmlにログアウトリンク追加してください。
<仕様>
・ログアウトリンクによってセッション破棄するようにすること
*/
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	String[][] user = {
			{ "a", "aaa" },
			{ "sht", "pass" }
	};

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Useful use = new Useful();

		String log = use.judgeNull( request.getParameter("log") );

		// ログイン処理
		if( use.isNull(log) && log.equals("in") ) {
			String name = use.judgeNull( request.getParameter("name") );
			String pass = use.judgeNull( request.getParameter("pass") );

			for (String[] strings : user) {
				if( name.equals(strings[0]) && pass.equals(strings[1]) ) {
					session.setAttribute("isLogin", "TRUE");
				}
			}
			if( use.isNull(session.getAttribute("isLogin")) ) System.out.println("ログイン成功");
			else System.out.println("ログイン失敗");
		}

		// ログアウト処理
		else if( use.isNull(log) && log.equals("out") ) {
			if( use.isNull(session.getAttribute("isLogin")) ) {
				session.invalidate();
				System.out.println("ログアウト成功");
			}
			else System.out.println("ログアウト失敗");
		}

		// エラー処理
		else System.out.println("ログインエラー");

		RequestDispatcher rd = request.getRequestDispatcher("/practice/chapter05/index.html");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
