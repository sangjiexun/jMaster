package sht.practice.chapter01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	Getリクエストで数値のアルファベット（小文字）のパラメータを受け取り、大文字に変換した結果をHTMLとして返すサーブレットを作成してください
	※HTMLからパラメータを渡す際は、Formを使うかリンクを使うこと
 */
@WebServlet("/program04")
public class No004 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		beginTags(out);

		// ◆◆◆◆◆◆◆◆◆◆　↓↓↓　ここから　↓↓↓　◆◆◆◆◆◆◆◆◆◆　入力値の受け取りと未入力の場合のメッセージ
		String serAlphabet = request.getParameter( "valueAlphabet" );
		if( serAlphabet == null || serAlphabet.length() == 0 ) {
			out.println(  "値を入力してください" );
			endTags(out);
			return;
		}
		// ◆◆◆◆◆◆◆◆◆◆　↑↑↑　ここまで　↑↑↑　◆◆◆◆◆◆◆◆◆◆　入力値の受け取りと未入力の場合のメッセージ

		// 入力された小文字を出力
		emphasisTags( out, serAlphabet );
		out.println("→");

		// 大文字に変換・出力
		serAlphabet = serAlphabet.toUpperCase();
		emphasisTags( out, serAlphabet );

		endTags(out);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void beginTags( PrintWriter out ) {
		out.println( "<!DOCTYPE html>" );
		out.println( "<html><head><meta charset=\"UTF-8\"><title>問題4</title></head>" );
		out.println( "<body><div style=\"padding: 10px; width: 600px; background: #CFC; font: 12pt Meiryo;\">" );
		out.println( "<div style=\"padding: 10px; background: #FFC; text-align: center;\">" );
	}
	private void endTags( PrintWriter out ) {
		out.println( "</div>FOOTER_v005<br><a href=\"practice/chapter01/no004.html\">BACK</a>" );
		out.println( "</div></body></html>" );
	}
	private void emphasisTags( PrintWriter out, String text ) {
		out.println( "<span style = \"font-size: 24pt;\">" + text + "</span>" );
	}
}