package sht.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	3つの整数を入力値として持つHTMLと、
	その整数を乗算した結果を返すサーブレットを作成してください。
*/
@WebServlet("/No001")
public class No001 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		out.println( "<!DOCTYPE html><html><head><title>No_Name</title></head><body>" );
		out.println( "<div style=\"background:#FFC; padding:10px; width:600px;\">" );
		out.println( "<div style=\"background:#CFC; padding:20px;\">" );


		String sumValue01 = request.getParameter("sumValue01");
		String sumValue02 = request.getParameter("sumValue02");
		String sumValue03 = request.getParameter("sumValue03");
		if(		sumValue01 == null || sumValue01.length() == 0 ||
				sumValue02 == null || sumValue02.length() == 0 ||
				sumValue03 == null || sumValue03.length() == 0 ) {
			getNonValue(out);
			endTags(out);
			return;
		}


		int serSumValue01, serSumValue02, serSumValue03, serSum;
		try {
			serSumValue01 = Integer.parseInt( sumValue01 );
			serSumValue02 = Integer.parseInt( sumValue02 );
			serSumValue03 = Integer.parseInt( sumValue03 );
			serSum = serSumValue01 + serSumValue02 + serSumValue03;
		}
		catch (NumberFormatException e) {
			getFalseValue(out);
			endTags(out);
			return;
			// 以降の処理で変数の初期化がない場合のエラー処理でもここにリターン入れれば許してくれる（serSumのこと）
		}


		out.println( sumValue01 + " + " + sumValue02 + " + " + sumValue03 + " = " + serSum );
		endTags(out);
	}
	private void getNonValue(PrintWriter out) {
		out.println( "みっつの整数を入力してください。" );
	}
	private void getFalseValue(PrintWriter out) {
		out.println( "整数を入力してください。" );
	}
	private void endTags(PrintWriter out) {
		out.println( "</div><hr>フッター_v06<br><a href=\"practice/no001.html\">BACK</a></div>" );
		out.println( "</body></html>" );
	}
}
