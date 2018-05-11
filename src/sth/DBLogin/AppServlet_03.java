package sth.DBLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**

	DBの取り方を変える

	◆JSPで入力を求める。
	◇JSPで入力されたユーザー名・パスワードを受け取る。
	◇DBにアクセスする。
	◇DBのユーザー情報を取得。
	◇ユーザー情報（DB）と入力値（JSP）の比較。
	◇一致。
	◇JSPのマイページに遷移。
	◆マイページ表示。
*/
@WebServlet("/AppServlet_03")
public class AppServlet_03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();


		try {
			// JSPで入力されたユーザー名・パスワードを受け取る。
			String userName	= request.getParameter("userName");
			String password	= request.getParameter("password");

//			out.println("ERROR CHECK1<br>");

			// マイページでログアウトボタンが押されたときの処理
			logout(request, response);

			// ログイン重複時の処理
			overLap(request, response);


			// DBのユーザー情報を取得。
			AppDAO ad = new AppDAO();
			LoginBean userInfoDB = ad.userInfo( userName, password/*, response*/ );


			// 出力テスト（エラーのときだけ出るはず）
			out.println(userInfoDB.getUserName() + " + br<br>");
			out.println(userInfoDB.getPassword() + " + br<br><br>");


			// ログイン成功時の処理
			if(		userName.equals( userInfoDB.getUserName() ) &&
					password.equals( userInfoDB.getPassword() )
			/* if条件式ここまで */) {
				HttpSession session = request.getSession();
				session.setAttribute( "ログイン", "できたよ" );


				session.setAttribute( "userName", userInfoDB.getUserName() );
				session.setAttribute( "password", userInfoDB.getPassword() );
				RequestDispatcher rd = request.getRequestDispatcher("/loginJSP/myPage.jsp");
				rd.forward(request, response);
			}
			else {
				// エラー処理・ログインできなかった時の処理
			}
		}
		catch (Exception e) {
			// エラー処理
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
	/**
		ログアウトボタンが押されたときの処理
	*/
	private void logout( HttpServletRequest request, HttpServletResponse response ) {
		String log = request.getParameter("log");
		try {
			if( log.equals("out") ) {
				// セッションが無い時、sessionは「null」
				HttpSession session = request.getSession(false);
				if( session != null ) {
					// session破棄・ログアウト
					session.invalidate();
					RequestDispatcher rd = request.getRequestDispatcher("/loginJSP/login.jsp");
					rd.forward(request, response);
				}
			}
		}
		catch (Exception e) {
		}
	}
	/**
		ログインかぶったら重複してるって言われる。
	*/
	private void overLap( HttpServletRequest request, HttpServletResponse response ) {
		try {
			// セッションが無い（ログインしていない）時、セッションの中の「"ログイン"」はnull
			HttpSession session = request.getSession(false);

			// セッションがある（ログインしてる）ときはマイページに飛ばす。
			if( session.getAttribute("ログイン") != null ) {
				// リクエストアトリビュートでもうログインしてるよって警告する
				request.setAttribute( "err", "既にログインしています。" );
				RequestDispatcher rd = request.getRequestDispatcher("/loginJSP/myPage.jsp");
				rd.forward(request, response);
			}
		}
		catch (Exception e) {
		}
	}
}