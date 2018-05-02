package sht.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
	ユーザ名・パスワード・メールアドレスを入力して送信すると、
	ユーザが入力した情報を最終確認する画面が表示されるようにアプリケーションを作成してください。
	※未入力時のエラー処理も記述すること
*/
@WebServlet("/No003")
public class No003 extends HttpServlet {
	String userName[] = { "a", "b", "c" }, password[] = { "aaa", "bbb", "ccc" }, mailAddless[] = { "a@a.com", "b@b.co.jp", "c@c.ne.jp" };

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		beginTags(out);


		// HTML内の「name="hatena"」を取得（いらないかも？）
//		String hatena = request.getParameter( "hatena" );

		// HTML内の「name="○○"」を取得
		String userName = request.getParameter( "userName" );
		String password = request.getParameter( "password" );
		String mailAddless = request.getParameter( "mailAddless" );

		for ( int i = 0; i < this.userName.length; i++ ) {
			if(		userName.equals( this.userName[ i ] ) &&
					password.equals( this.password[ i ] ) &&
					mailAddless.equals( this.mailAddless[ i ] )
			) {
				// ログインしたよーって言っている
				HttpSession judgeLogin = request.getSession();
				// judgeLoginにtrueといれて、ログインしたことを教えている。
				judgeLogin.setAttribute("judgeLogin", "true");
			}
		}


		endTags(out);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void beginTags(PrintWriter out) {
		out.println( "<!DOCTYPE html><html><head><title>No_Name</title></head><body>" );
		out.println( "<div style=\"background:#FFC; padding:10px; width:600px;\">" );
		out.println( "<div style=\"background:#CFC; padding:20px;\">" );
	}
	private void endTags(PrintWriter out) {
		out.println( "</div><hr>フッター_v001<br><a href=\"practice/no002.html\">BACK</a></div>" );
		out.println( "</body></html>" );
	}
}