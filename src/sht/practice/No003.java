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
	String userName[] = { "a", "b", "c" }, password[] = { "aaa", "bbb", "ccc" }, mailAddress[] = { "a@a.com", "b@b.co.jp", "c@c.ne.jp" };

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		beginTags(out);


		// HTML内の「name="hatena"」を取得（hidden・いらないかも？）
//		String hatena = request.getParameter( "hatena" );

		// HTML内の「name="○○"」を取得
		String userName = request.getParameter( "userName" );
		String password = request.getParameter( "password" );
		String mailAddress = request.getParameter( "mailAddress" );


		// ◆◆◆◆◆◆◆◆◆◆　↓↓↓　ここから　↓↓↓　◆◆◆◆◆◆◆◆◆◆　未入力の場合のメッセージ
		if(		userName == null || userName.length() ==0 ||
				password == null || password.length() ==0 ||
				mailAddress == null || mailAddress.length() ==0
		) {
			out.println( "ユーザー名・パスワード・メールアドレスを入力してください" );
			endTags(out);
			return;
		}
		// ◆◆◆◆◆◆◆◆◆◆　↑↑↑　ここまで　↑↑↑　◆◆◆◆◆◆◆◆◆◆　未入力の場合のメッセージ


		for ( int i = 0; i < this.userName.length; i++ ) {
			if(		userName.equals( this.userName[ i ] ) &&
					password.equals( this.password[ i ] ) &&
					mailAddress.equals( this.mailAddress[ i ] )
			) {
				// セッションを作成（破棄されるまで継続）
				HttpSession sessionActive = request.getSession();
				// セッション情報の中に「ログイン判定（judgeLogin）：ログイン中（true）」と記録する
				// つまり、ログイン中だよーと言っている
				sessionActive.setAttribute( "judgeLogin", "true" );

				emphasisTags( out, "ログイン成功！" );
//				endTags(out);
			}
		}


		// ◆◆◆◆◆◆◆◆◆◆　↓↓↓　ここから　↓↓↓　◆◆◆◆◆◆◆◆◆◆　ログインできてなない場合のメッセージ（今回いらない？）
		// セッションがない場合（1つ目のチェック）
		if( request.getSession(false) == null ) {
			emphasisTags( out, "入力が間違っています" );
			out.println( "ユーザー情報が一致しません" );
			endTags(out);
			return;
		}
		// セッションがある場合（1つ目のチェック）
		else {
			// ログイン状態でない場合（2つ目のチェック）
			// セッションがあるのに、ログアウト状態の場合・今回のケースではほぼないパターン
			if(		request.getSession().getAttribute("judgeLogin") == null ||
					!request.getSession().getAttribute("judgeLogin").equals("true")
			) {
				emphasisTags(out, "入力が間違っています");
				out.println( "ユーザー情報が一致しません" );
				endTags(out);
				return;
			}
		}
		// ◆◆◆◆◆◆◆◆◆◆　↑↑↑　ここまで　↑↑↑　◆◆◆◆◆◆◆◆◆◆　ログインできてなない場合のメッセージ（今回いらない？）


		// ◆◆◆◆◆◆◆◆◆◆　↓↓↓　ここから　↓↓↓　◆◆◆◆◆◆◆◆◆◆　ログイン情報の確認
		// パスワードを文字数分「丸」に置き換える
		String hiddenPassword = "";
		for (int i = 0; i < password.length(); i++) {
			hiddenPassword += "●";
		}

		out.print( "<table style =\"border-spacing: 5px; text-align: left;\" class=\"formTable\">" );
		out.print( "	<tr>" );
		out.print( "		<td style=\"width: 150px\">ユーザー名</td>" );
		out.print( "		<td>" + userName + "</td>" );
		out.print( "	</tr>" );
		out.print( "	<tr>" );
		out.print( "		<td style=\"width: 150px\">パスワード</td>" );
		out.print( "		<td>" + hiddenPassword + "</td>" );
		out.print( "	</tr>" );
		out.print( "	<tr>" );
		out.print( "		<td style=\"width: 150px\">メールアドレス</td>" );
		out.print( "		<td>" + mailAddress + "</td>" );
		out.print( "	</tr>" );
		out.print( "</table>" );
		// ◆◆◆◆◆◆◆◆◆◆　↑↑↑　ここまで　↑↑↑　◆◆◆◆◆◆◆◆◆◆　ログイン情報の確認


		endTags(out);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void beginTags(PrintWriter out) {
		out.println( "<!DOCTYPE html><html><head><title>No_Name</title></head><body>" );
		out.println( "<div style=\"background:#FF9; padding:10px; width:600px;\">" );
		out.println( "<div style=\"background:#9F9; padding:20px;\">" );
	}
	private void endTags(PrintWriter out) {
		out.println( "</div><hr style = \"border: solid 2px #CCC;\">フッター_v005<br><a href=\"practice/no003.html\">BACK</a></div>" );
		out.println( "</body></html>" );
	}
	private void emphasisTags( PrintWriter out, String text ) {
		out.println( "<span style = \"font-size: 24pt;\">" + text + "</span>" );
	}
}