package sth.DBLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sht.dao.DAOException;

public class AppLogProcess {
	/**
		ログイン処理
	*/
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			PrintWriter out = response.getWriter();

			// JSPで入力されたユーザー名・パスワードを受け取る。
			String userName	= request.getParameter("userName");
			String password	= request.getParameter("password");


			// DBのユーザー情報を取得。
			AppDAO ad = new AppDAO();
			LoginBean userInfoDB;
			userInfoDB = ad.userInfo( userName, password/*, response*/ );


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
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	/**
		ログアウトボタンが押されたときの処理
	*/
	protected void logout( HttpServletRequest request, HttpServletResponse response, String log ) {
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
	protected boolean overLap( HttpServletRequest request, HttpServletResponse response ) {
		try {
			// セッションが無い（ログインしていない）時、セッションの中の「"ログイン"」はnull
			HttpSession session = request.getSession(false);

			// セッションがある（ログインしてる）ときはマイページに飛ばす。
			if( session.getAttribute("ログイン") != null ) {
				// リクエストアトリビュートでもうログインしてるよって警告する
				request.setAttribute( "readyLogin", "既にログインしています。" );
				RequestDispatcher rd = request.getRequestDispatcher("/loginJSP/myPage.jsp");
				rd.forward(request, response);
				return true;		// 既に誰かがログインしてる = true
			}
		}
		catch (Exception e) {
		}
		return false;		// まだ誰もログインしてない = false
	}
}