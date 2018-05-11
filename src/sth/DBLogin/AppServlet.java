package sth.DBLogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@WebServlet("/AppServlet")
public class AppServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("ERROR CHECK1<br>");

			// ログイン・ログアウトの命令情報を取得
			String log = request.getParameter("log");

			// ログイン・ログアウト関連、エラー関連処理が出来るようにする。
			AppLogProcess	alp = new AppLogProcess();
			AppErrorProcess	aep = new AppErrorProcess();

			// サーブレットのURL直打ち禁止処理
			aep.tabooURL(request, response, log);

			// マイページでログアウトボタンが押されたときの処理
			alp.logout(request, response, log);

			// ログイン重複時の処理
			if( alp.overLap(request, response) ) return;

			// ログイン処理
			alp.login(request, response);

		}
		catch (Exception e) {
			// エラー処理
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}