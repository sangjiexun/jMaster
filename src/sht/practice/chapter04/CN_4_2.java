package sht.practice.chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	■問題２
	ボタンを押すとランダムな数値が画面に表示されるアプリケーションを作成してください。
 */
@WebServlet("/CN_4_2")
public class CN_4_2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		beginTags(out);


		// マスドットランダムは括弧をつけて変換させよう。
		out.println( "乱数 : " + (int)(Math.random() * 10) );


		endTags(out);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void beginTags(PrintWriter out) {
		out.println( "<!DOCTYPE html><html><head><title>No_Name</title></head><body>" );
		out.println( "<div style=\"background:#FFC; padding:10px; width:600px;\">" );
		out.println( "<div style=\"background:#CFC; padding:20px;\">" );
	}
	private void endTags(PrintWriter out) {
		out.println( "</div><hr>フッター_v012<br><a href=\"practice/no002.html\">BACK</a></div>" );
		out.println( "</body></html>" );
	}
}