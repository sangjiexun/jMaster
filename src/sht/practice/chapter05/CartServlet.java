package sht.practice.chapter05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
■問題3
問題1で作成したindex.htmlに本をカートに入れるアプリケーションを作成してください。
<仕様>
・本のタイトルと価格を持つBookクラス（JavaBeans）を作成すること
・index.htmlで3つ以上本のリンクを作成すること（リンクにタイトルと価格のパラメータを入れること）
・ログイン成功している状態でしか本を追加することができないこと
*/
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
