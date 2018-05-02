package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final String USER[] = {"Jack", "a"}, PASS[] = {"abc", "aaa"};

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.println( "<html><head><title>SESSION0427</title></head><body>" );

		// ログインできたかを判断するやつ
		boolean judgLogin = false;

		String action = request.getParameter( "action" );
		if( action.equals( "login" ) ) {
			String name = request.getParameter( "name" );
			String passWord = request.getParameter( "pw" );

			for (int i = 0; i < PASS.length; i++) {
				if( name.equals( USER[i] ) && passWord.equals( PASS[i] ) ) {
					// isLoginにtrueを格納
					HttpSession session = request.getSession();
					session.setAttribute( "isLogin", "true" );

					judgLogin = true;
				}
			}
			if( judgLogin == true )		out.println( "<h1>ログイン成功</h1>" );
			else						out.println( "<h1>ログイン失敗</h1>" );
		}
		else if( action.equals( "logout" ) ) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				// セッション情報の破棄
				session.invalidate();
				out.println( "<h1>ログアウトしたよ</h1>" );

				judgLogin = false;
			}
		}
		out.println( "<hr>フッター" );
		out.println( "<a href=\"/jMaster/session.html\">商品リスト</a>" );
		out.println( "</body></html>" );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}