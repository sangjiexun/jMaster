package sht.practice.chapter05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
■問題１
名前とパスワードでログインするアプリケーションを作成してください。
>>>仕様
・ログインに成功した際にセッションを生成し、名前をセッション情報に格納すること
・ログイン成功後はログインした名前を表示すること
■問題２
問題１で作成したindex.htmlにログアウトリンク追加してください。
<仕様>
・ログアウトリンクによってセッション破棄するようにすること
*/
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
