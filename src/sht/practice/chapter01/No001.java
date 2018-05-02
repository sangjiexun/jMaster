package sht.practice.chapter01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	Getリクエストで受け取り、「Hello Servlet Get!」と表示されるHTMLを返すサーブレットを作成してください
 */
@WebServlet("/program01")
public class No001 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		beginTags(out);

		out.println( "Hello Servlet Get!" );

		endTags(out);
	}
	private void beginTags(PrintWriter out) {
		out.println( "<!DOCTYPE html><html><head><title>問題01</title></head><body>" );
		out.println( "<div style=\"background:#FFC; padding:10px; width:600px;\">" );
		out.println( "<div style=\"background:#CFC; padding:20px;\">" );
	}
	private void endTags(PrintWriter out) {
		out.println( "</div><hr>フッター_v001<br></div>" );
		out.println( "</body></html>" );
	}
}