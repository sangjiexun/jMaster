package sht.practice.chapter01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
	Postリクエストで受け取った場合はGetリクエストへ処理を任せ、
	Getリクエストで受け取った場合は「Hello World」と表示されるHTMLを返すサーブレットを作成してください
*/
@WebServlet("/program05")
public class No005 extends HttpServlet {
	boolean judgePost_Get = false;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		beginTags(out);

		// POSTとGETの判定
		if( judgePost_Get == true ) out.println( "POST<br>" );
		else if( judgePost_Get == false ) out.println( "GET<br>" );
		else out.println( "???<br>" );

		emphasisTags( out, "Hello World" );

		endTags(out);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		judgePost_Get = true;
		doGet(request, response);
		judgePost_Get = false;
	}
	private void beginTags( PrintWriter out ) {
		out.println( "<!DOCTYPE html>" );
		out.println( "<html><head><meta charset=\"UTF-8\"><title>問題5</title></head>" );
		out.println( "<body><div style=\"padding: 10px; width: 600px; background: #CFC; font: 12pt Meiryo;\">" );
		out.println( "<div style=\"padding: 10px; background: #FFC; text-align: center;\">" );
	}
	private void endTags( PrintWriter out ) {
		out.println( "</div>FOOTER_v005<br><a href=\"practice/chapter01/no005.html\">BACK</a>" );
		out.println( "</div></body></html>" );
	}
	private void emphasisTags( PrintWriter out, String text ) {
		out.println( "<span style = \"font-size: 24pt;\">" + text + "</span>" );
	}
}