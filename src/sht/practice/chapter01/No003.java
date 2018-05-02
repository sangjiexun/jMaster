package sht.practice.chapter01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	Postリクエストで数値のパラメータを受け取り、100倍した結果をHTMLとして返すサーブレットを作成してください
*/
@WebServlet("/program03")
public class No003 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; Charset=UTF-8" );
		PrintWriter out = response.getWriter();
		beginTags(out);

		// フォームで入力された値は文字列としてサーブレットに送られるのでString参照型で受け取る。
		// JavaScriptの「documet.getElementById();」みたいなことをしている。
		// JavaScriptでは「id="任意の名前"」だけど、Javaサーブレットでは「name="任意の名前"」
		String serValue =  request.getParameter( "value" );

		// 値が入力されたかを判別する if文
		// 入力値無しだった場合は終了タグを出力してリターンでメソッド強制終了
		if( serValue == null || serValue.length() == 0 ) {
			out.println( "入力をし\nてください" );
			endTags(out);
			return;
		}

		// 入力値と百倍にした値の格納先
		int serValueInt, centupleValueInt;

		// 入力された値を整数に変換する
		// 入力された値が整数でない場合（エラーを吐く場合）の処理を catch文に記述
		// 終了タグを出力してリターンでメソッド強制終了
		try {
			serValueInt = Integer.parseInt(serValue);
			centupleValueInt = serValueInt * 100;
		}
		catch ( NumberFormatException e ) {
			out.println( "整数を入力してください" );
			endTags(out);
			return;
		}

		// 入力数値と計算結果の出力
		out.println( serValueInt + " * 100 = " + centupleValueInt );

		// 終了タグを出力
		endTags(out);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void beginTags(PrintWriter out) {
		out.println( "<!DOCTYPE html><html><head><title>問題03</title></head><body>" );
		out.println( "<div style=\"background:#FFC; padding:10px; width:600px;\">" );
		out.println( "<div style=\"background:#CFC; padding:20px;\">" );
	}
	private void endTags(PrintWriter out) {
		out.println( "</div><hr>フッター_v001<br><a href=\"practice/chapter01/no003.html\">BACK</a></div>" );
		out.println( "</body></html>" );
	}
}