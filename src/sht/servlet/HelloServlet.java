package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// クラス名とは別にした方がセキュリティ的に安全
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// HttpServletクラスのオーバーライドメソッド
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset = UTF-8" );
		PrintWriter out = response.getWriter();
//		out.println( "<html><head><title>ハローサーブレット</title></head><body>" );
//		for ( int i = 0; i < 10; i++ ) {
//			out.println( "<h1>ようこそサーブレット123123あｓｄｆｇｈｊｋｌ</h1>" );
//		}
//		out.println( "数字：" + 100 );
//		out.print( "</body></html>" );
		out.print( "<!DOCTYPE html>\r\n" +
				"<html lang=\"ja\">\r\n" +
				"	<head>\r\n" +
				"		<meta charset=\"UTF-8\">\r\n" +
				"		<title>初めてのHTML</title>\r\n" +
				"		<link rel=\"stylesheet\" href=\"style/style.css\">\r\n" +
				"	</head>\r\n" +
				"\r\n" +
				"	<body>\r\n" +
				"		<div class=\"containts\">\r\n" +
				"			<span style=\"font-size:24pt;\">タイトルが入る</span>\r\n" +
				"\r\n" +
				"			<nav style=\"position:relative;\">\r\n" +
				"				<a href=\"http://shtech.co.jp\" target=\"_blank\">\r\n" +
				"					<div>SHT</div>\r\n" +
				"				</a>\r\n" +
				"				<a href=\"https://google.co.jp\" target=\"_blank\">\r\n" +
				"					<div style=\"position:absolute;top:0;right:0;\">Google</div>\r\n" +
				"				</a>\r\n" +
				"			</nav>\r\n" +
				"\r\n" +
				"			<div class=\"heading\"><h1>おいしいごはん！</h1></div>\r\n" +
				"			<p>手作りハンバーグ</p>\r\n" +
				"\r\n" +
				"			<div class=\"heading\"><h2>材料</h2></div>\r\n" +
				"			<ul>	<!--アンオーダード リスト（箇条書き）-->\r\n" +
				"				<li>ひき肉</li>\r\n" +
				"				<li>たまねぎ</li>\r\n" +
				"				<li>たまご</li>\r\n" +
				"			</ul>\r\n" +
				"\r\n" +
				"			<div class=\"heading\"><h2>手順</h2></div>\r\n" +
				"			<ol>	<!--オーダード リスト（手順あり）-->\r\n" +
				"				<li>こねる</li>\r\n" +
				"				<li>焼く</li>\r\n" +
				"			</ol>\r\n" +
				"\r\n" +
				"			<img src=\"image/flower.png\" alt=\"アジサイの画像\">\r\n" +
				"\r\n" +
				"			<br><br>\r\n" +
				"\r\n" +
				"			<table class=\"round\">\r\n" +
				"				<tr><th>名前</th><th>住所</th></tr>\r\n" +
				"				<tr><td>織田信長</td><td>東京都千代田区神田町</td></tr>\r\n" +
				"				<tr><td>豊臣秀吉</td><td>愛知県豊田市三河町</td></tr>\r\n" +
				"				<tr><td>徳川家康</td><td>東京都江戸川区鹿骨町</td></tr>\r\n" +
				"			</table>\r\n" +
				"\r\n" +
				"			<br>\r\n" +
				"\r\n" +
				"			<form action=\"login.servlet\" method=\"post\">\r\n" +
				"				<table>\r\n" +
				"					<tr>\r\n" +
				"						<td>メールアドレス　</td>\r\n" +
				"						<td><input type=\"text\" name=\"email\" size=\"50\" placeholder=\"メールアドレスを入力してください\"></td>\r\n" +
				"					</tr>\r\n" +
				"					<tr>\r\n" +
				"						<td>パスワード</td>\r\n" +
				"						<td><input type=\"password\" name=\"password\" size=\"50\" placeholder=\"パスワードを入力してください\"></td>\r\n" +
				"					</tr>\r\n" +
				"					<tr>\r\n" +
				"						<td>都道府県</td>\r\n" +
				"						<td>\r\n" +
				"							<select name=\"city\">\r\n" +
				"								<option value=\"tokyo\">東京</option>\r\n" +
				"								<option value=\"nagoya\">名古屋</option>\r\n" +
				"								<option value=\"osaka\">大阪</option>\r\n" +
				"								<option value=\"hokkaido\">北海道</option>\r\n" +
				"								<option value=\"hukuoka\">福岡</option>\r\n" +
				"							</select>\r\n" +
				"						</td>\r\n" +
				"					</tr>\r\n" +
				"					<tr>\r\n" +
				"						<td>コメント</td>\r\n" +
				"						<td><textarea name=\"comment\" cols=\"37\"></textarea></td>\r\n" +
				"					</tr>\r\n" +
				"					<tr>\r\n" +
				"					<td></td>\r\n" +
				"						<td><input type=\"submit\" value=\"送信\"></td>\r\n" +
				"					</tr>\r\n" +
				"				</table>\r\n" +
				"			</form>\r\n" +
				"			<hr>\r\n" +
				"			footer\r\n" +
				"		</div>\r\n" +
				"	</body>\r\n" +
				"</html>\r\n" +
				"" );

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}