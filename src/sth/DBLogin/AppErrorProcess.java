package sth.DBLogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AppErrorProcess {
	/**
		サーブレットのURL直打ち禁止処理
	*/
	protected void tabooURL( HttpServletRequest request, HttpServletResponse response, String log ) {
		try {
			if(log == null) {
				// セッションを使えるようにする（新しくセッションを作る訳ではない）
				HttpSession session = request.getSession(false);

				// ログイン情報が無ければ（ログインできていなければ）実行される。
				if( session == null || session.getAttribute("ログイン") == null ){
					RequestDispatcher rd = request.getRequestDispatcher("/loginJSP/login.jsp");
					rd.forward(request, response);
				}
			}
		}
		catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
