package sht.practice.chapter02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sht.myJava.Tags;

/*
	ユーザ名とパスワードを受け取り、ユーザ名が「user」、パスワードが「pass」の場合のみ
	「ログイン成功」と表示するHTMLを返すサーブレットを作成してください
	※上記以外の場合は「ログイン失敗」と返すようにすること
*/
@WebServlet("/Ch2No003")
public class Ch2No003 extends HttpServlet {
	String userName = "user", password = "pass";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();

		// それぞれ、更新チェッカー、チャプター、課題番号の初期化
		Tags tag = new Tags( "003", "02",  "003" );
		tag.begin(out);

		// HTML内の「name="○○"」を取得
		String userName = request.getParameter( "userName" );
		String password = request.getParameter( "password" );


		// ◆◆◆◆◆◆◆◆◆◆　↓↓↓　ここから　↓↓↓　◆◆◆◆◆◆◆◆◆◆　未入力の場合のメッセージ
		if(		userName == null || userName.length() ==0 ||
				password == null || password.length() ==0
		) {
			tag.emphasis( out, "ログイン失敗<br>" );
			out.println( "ユーザー名・パスワードを入力してください" );
			tag.end(out);
			return;
		}
		// ◆◆◆◆◆◆◆◆◆◆　↑↑↑　ここまで　↑↑↑　◆◆◆◆◆◆◆◆◆◆　未入力の場合のメッセージ


		if(		userName.equals( this.userName ) &&
				password.equals( this.password )
		) {
			// セッションを作成（破棄されるまで継続）
			HttpSession sessionActive = request.getSession();
			// セッション情報の中に「ログイン判定（judgeLogin）：ログイン中（true）」と記録する
			// つまり、ログイン中だよーと言っている
			sessionActive.setAttribute( "judgeLogin", "true" );

			tag.emphasis( out, "ログイン成功！<br>" );
		}
		else {
			tag.emphasis( out, "ログイン失敗<br>" );
			out.println( "ユーザー情報が一致しません" );
			tag.end(out);
			return;

		}


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
		out.print( "</table>" );
		// ◆◆◆◆◆◆◆◆◆◆　↑↑↑　ここまで　↑↑↑　◆◆◆◆◆◆◆◆◆◆　ログイン情報の確認


		tag.end( out );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}