package sht.practice.chapter02;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
	Getリクエストで受け取り、現在の日時をHTMLとして返すサーブレットを作成してください
*/
@WebServlet("/Ch2No001")
public class Ch2No001 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		beginTags(out);


		// 現在の日時を取得
		LocalDateTime now = LocalDateTime.now();

		// 表示方法を指定
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu年MM月dd日　hh : mm");

		//　出力
		emphasisTags( out, dtf.format(now) );


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