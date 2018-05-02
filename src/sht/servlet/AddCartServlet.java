package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.println( "<html><head><title>SESSION0427</title></head><body>" );

		// 追記
		HttpSession session = request.getSession(false);
		if (session == null) {
			out.println( "<a href=\"/jMaster/session.html\">商品リスト</a><hr>" );
			out.println( "<h1>ログインしてね</h1>" );
			return;
		}
		else {
			String isLogin = (String)session.getAttribute( "isLogin" );
			if( isLogin == null || !isLogin.equals( "true" ) ) {
				out.println( "<a href=\"/jMaster/session.html\">商品リスト</a><hr>" );
				out.println( "<h1>ログインしてね</h1>" );
				return;
			}
		}


		String productNo = request.getParameter( "productNo" );
		int num = Integer.parseInt(productNo);
		String productName = null;

		switch (num) {
		case 100:
			productName = "パソコン";
			break;
		case 101:
			productName = "プリンター";
			break;
		case 102:
			productName = "カメラ";
			break;
		case 999:
			productName = "";
			break;
		default:
			productName = "エラー";
			break;
		}

		// ゲットセッション
//		HttpSession session = request.getSession();

		// カートを作る準備（セッション領域の取得・右辺をリストに対応できるようキャストしている）
		@SuppressWarnings( "unchecked" )
		ArrayList<String> cart = ( ArrayList<String> ) session.getAttribute( "products" );

		out.println( "<a href=\"/jMaster/session.html\">商品リスト</a><hr>" );
		out.println( "<br>カート<hr>" );

		// カートが無ければつくる
		if( cart == null ) {
			cart = new ArrayList<>();
			session.setAttribute( "products", cart );
			out.println( "カートは空です" );
		}

		// カートに追加・削除
		try {
			if( productName == "" ) {
				cart.remove( cart.size() - 1 );
			}
			else 	cart.add( productName );
		}
		catch (Exception e) {
			out.println( "カートは空です" );
		}

		for (int i = 0; i < cart.size(); i++) {
			out.println( i + 1 );
			out.println( "：" + cart.get(i) + "<br>" );
		}


		out.println( "<hr>フッター◆" );
		out.println( "</body></html>" );
	}
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		doGet(request, response);
	}
}
