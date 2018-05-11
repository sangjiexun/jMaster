package sth.DBLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/AppServlet_02")
public class AppServlet_02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			// JSPで入力されたユーザー名・パスワードを受け取る。
			String userName	= request.getParameter("userName");
			String password	= request.getParameter("password");

//			out.println("ERROR CHECK1<br>");

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
				request.setAttribute( "userName", userInfoDB.getUserName() );
				request.setAttribute( "password", userInfoDB.getPassword() );
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
}