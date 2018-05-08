package sht.practice.chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.myJava.Tags;
/*
	3つの整数を入力値として持つHTMLと、
	その整数を乗算した結果を返すサーブレットを作成してください。
*/
@WebServlet("/CN_4_1")
public class CN_4_1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();

		// それぞれ、更新チェッカー、チャプター、課題番号の初期化
		Tags tag = new Tags( "001", "04",  "001" );
		tag.begin(out);


		String sumValue01 = request.getParameter("sumValue01");
		String sumValue02 = request.getParameter("sumValue02");
		String sumValue03 = request.getParameter("sumValue03");
		if(		sumValue01 == null || sumValue01.length() == 0 ||
				sumValue02 == null || sumValue02.length() == 0 ||
				sumValue03 == null || sumValue03.length() == 0 ) {
			getNonValue(out);
			tag.end(out);
			return;
		}


		int serSumValue01, serSumValue02, serSumValue03, serSum;
		try {
			serSumValue01 = Integer.parseInt( sumValue01 );
			serSumValue02 = Integer.parseInt( sumValue02 );
			serSumValue03 = Integer.parseInt( sumValue03 );
			serSum = serSumValue01 * serSumValue02 * serSumValue03;
		}
		catch (NumberFormatException e) {
			getFalseValue(out);
			tag.end(out);
			return;
			// 以降の処理で変数の初期化がない場合のエラー処理でもここにリターン入れれば許してくれる（serSumのこと）
		}


		out.println( sumValue01 + " * " + sumValue02 + " * " + sumValue03 + " = " + serSum );
		tag.end(out);
	}
	private void getNonValue(PrintWriter out) {
		out.println( "みっつの整数を入力してください。" );
	}
	private void getFalseValue(PrintWriter out) {
		out.println( "整数を入力してください。" );
	}
}
