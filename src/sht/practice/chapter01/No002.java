package sht.practice.chapter01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	Postリクエストで受け取り、「Hello Servlet Post!」と表示されるHTMLを返すサーブレットを作成してください。
	※Postリクエストを行うためにHTMLのフォームを作成する必要があります。
*/
@WebServlet("/program02")
public class No002 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		beginTags(out);

		out.println( "Hello Servlet Post" );

		endTags(out);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void beginTags(PrintWriter out) {
		out.println( "<!DOCTYPE html><html><head><title>問題02</title></head><body>" );
		out.println( "<div style=\"background:#FFC; padding:10px; width:600px;\">" );
		out.println( "<div style=\"background:#CFC; padding:20px;\">" );
	}
	private void endTags(PrintWriter out) {
		out.println( "</div><hr>フッター_v003<br><a href=\"practice/chapter01/no002.html\">BACK</a></div>" );
		out.println( "</body></html>" );
	}
}