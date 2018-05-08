package sht.practice.chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.myJava.Tags;
/*
HTMLのフォームから日本語を送信したデータをHTMLとして返すサーブレットを作成してください
*/
@WebServlet("/Ch3No003")
public class Ch3No003 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 日本語対応
		request.setCharacterEncoding("UTF-8");

		// それぞれ、更新チェッカー、チャプター、課題番号の初期化
		Tags tag = new Tags( "002", "03",  "003" );
		tag.begin(out);

		String serJpn = request.getParameter( "jpn" );

		if( serJpn == null || serJpn.length() == 0 ) {
			out.println("入力がありません");
			tag.end(out);
			return;
		}

		tag.emphasis(out, serJpn);
		tag.end(out);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}