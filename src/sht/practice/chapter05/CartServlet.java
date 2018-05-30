package sht.practice.chapter05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sht.origin.Useful;


/**
	■問題3
	問題1で作成したindex.htmlに本をカートに入れるアプリケーションを作成してください。
	＜仕様＞
	・本のタイトルと価格を持つBookクラス（JavaBeans）を作成すること
	・index.htmlで3つ以上本のリンクを作成すること（リンクにタイトルと価格のパラメータを入れること）
	・ログイン成功している状態でしか本を追加することができないこと
*/
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	List<CartBeans> list = new ArrayList<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);

		Useful use = new Useful();

		if(session == null) {
			System.out.println( "ログインしていません。" );
			RequestDispatcher rd = request.getRequestDispatcher("/practice/chapter05/index.html");
			rd.forward(request, response);
			return;
		}

		if( use.isNull(session.getAttribute("isLogin")) ) {
			switch ( use.judgeNull(request.getParameter("book")) ) {
				case "book01":
					list.add( new CartBeans("本01", "500") );
					break;
				case "book02":
					list.add( new CartBeans("本02", "1000") );
					break;
				case "book03":
					list.add( new CartBeans("本03", "1500") );
					break;
				default:
					System.out.println("ERROR");
					break;
			}

			for (CartBeans string : list) {
				System.out.println( "カート : " + string.getName() + ", " + string.getPrice() );
			}
			System.out.println();
		}
		else System.out.println( "ログインしていません。" );

		RequestDispatcher rd = request.getRequestDispatcher("/practice/chapter05/index.html");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
