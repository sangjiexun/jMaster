package sht.practice.chapter02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
	Postリクエストで数値を受け取り、
	受け取った数値に対する消費税を計算して
	結果をHTMLとして返すサーブレットを作成してください
	※Formを使用すること
*/
@WebServlet("/Ch2No002")
public class Ch2No002 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response. getWriter();
		beginTags(out);

		// 入力された価格を取得・未入力処理
		String serPrice = request.getParameter("price");
		if( serPrice == null || serPrice.length() == 0 ) {
			out.println("入力して");
			endTags(out);
			return;
		}

		// ◆◆◆◆◆ 試験出力 ◆◆◆◆◆
		out.println(serPrice + "<br>");

		// int整数型に変換（String(参照型) → int(変数型)の変換なのでパースイントを使う）
		int serPriceInt = (int) ( Integer.parseInt(serPrice) * 1.08 );





		endTags(out);
	}
	private void beginTags( PrintWriter out ) {
		out.println( "<!DOCTYPE html>" );
		out.println( "<html><head><meta charset=\"UTF-8\"><title>問題5</title></head>" );
		out.println( "<body><div style=\"padding: 10px; width: 600px; background: #CFC; font: 12pt Meiryo;\">" );
		out.println( "<div style=\"padding: 10px; background: #FFC; text-align: center;\">" );
	}
	private void endTags( PrintWriter out ) {
		out.println( "</div>FOOTER_v001<br><a href=\"practice/chapter01/no005.html\">BACK</a>" );
		out.println( "</div></body></html>" );
	}
	private void emphasisTags( PrintWriter out, String text ) {
		out.println( "<span style = \"font-size: 24pt;\">" + text + "</span>" );
	}
}