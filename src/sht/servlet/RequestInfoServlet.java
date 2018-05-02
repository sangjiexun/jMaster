package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfoServlet")
public class RequestInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.println( "<html><head><title>サーブレットかくにん0426</title></head><body>" );

		out.print( "<table>" );

		out.println( "<tr><td>リモートＩＰアドレス</td><td>"	+ request.getRemoteAddr() +				"</td></tr>" );
		out.println( "<tr><td>リクエストURI</td><td>"			+ request.getRequestURI() +					"</td></tr>" );
		out.println( "<tr><td>HTTPメソッド</td><td>"			+ request.getMethod() +					"</td></tr>" );
		out.println( "<tr><td>ブラウザの種類</td><td>"			+ request.getHeader( "User-Agent" ) +			"</td></tr>" );
		out.println( "<tr><td>利用可能ファイル種別　</td><td>"	+ request.getHeader( "Accept" ) +			"</td></tr>" );
		out.println( "<tr><td>利用可能言語</td><td>"			+ request.getHeader( "Accept-Language" ) +	"</td></tr>" );

		out.println( "</body></html>" );
	}
}
