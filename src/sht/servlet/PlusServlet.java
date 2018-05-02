package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.beans.PlusBean;

@WebServlet/*("/plus.html#")*/("/PlusServlet")
public class PlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
		// 文字コード設定して日本語にも対応できるようにしたよ
		request.setCharacterEncoding( "UTF-8" );
		String name = request.getParameter("name");
*/
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.println( "<html><head><title>サーブレットれんしう0426</title></head><body>" );

		// 足し算の値を受け取っている
		String num01 = request.getParameter("value1");
		String num02 = request.getParameter("value2");

		// 入力値がない場合の処理
		if( num01 == null || num01.length() == 0 || num02 == null || num02.length() == 0 ) {
			showNotEnterdError(out);
			return;
		}
		int i1;
		int i2;
		int answer;
		try {
			i1 = Integer.parseInt(num01);
			i2 = Integer.parseInt(num02);
			answer = i1 + i2;
		}

		// 入力値が整数じゃない場合の処理
		catch (NumberFormatException e) {
			showNotIntegerError(out);
			return;
		}

		// リクエストスコープにデータ格納
//		request.setAttribute( "data1", new Integer(i1) );
//		request.setAttribute( "data2", new Integer(i2) );
//		request.setAttribute( "answer", new Integer(answer) );

		// 豆に入れる
		PlusBean bean = new PlusBean(i1, i2, answer);
		request.setAttribute("plus", bean);


		// AnswerServletの呼出し部
		RequestDispatcher rd = request.getRequestDispatcher( "/AnswerServlet" );
		rd.forward(request, response);


		out.println( num01 + " + " + num02 + " = " + answer + "<br><br>" );

/*
		// ラジオボタンはひとつしか選べないので変数に格納
		String payment = request.getParameter( "pay" );
		// チェックボックスは複数選べるので配列に格納
		String values[] = request.getParameterValues( "site" );

		String selectedPayment;
		int cnt = 0;
		if( payment == null ) {
			selectedPayment = "選択されていません";
		}
		else {
			switch (payment) {
				case "card":
					selectedPayment = "クレジットカード";
					break;
				case "bank":
					selectedPayment = "銀行振り込み";
					break;
				case "cash":
					selectedPayment = "代引き";
					break;
				default:
					selectedPayment = "不正な処理を受け取りました。";
					break;
			}
		}
		String selectedSite = "";
		if( values == null ) {
			selectedSite = "選択されていません";
		}
		else {
			for (String site : values) {
				if(cnt > 0)selectedSite += "-";
				cnt = 0;
				switch (site) {
					case "fb":
						selectedSite += "FaceBook";
						cnt++;
						break;
					case "tw":
						selectedSite += "Twitter";
						cnt++;
						break;
					case "yt":
						selectedSite += "YouTube";
						cnt++;
						break;
					default:
						selectedSite += "不正な処理を受け取りました。";
						break;
				}
			}
		}
		out.println( "[ " + selectedPayment +  " ] が選択されました。" );
		out.println( "<br>[ " + selectedSite +  " ] が選択されました。" );



		if(name == null ) out.println( "<br>ようこそ" + name + "さん。" );
		else out.println( "<br>ようこそななしさん。" );



		String productNo = request.getParameter( "productNo" );
		int num = Integer.parseInt(productNo);
		String productName = null;

		switch (num) {
		case 100:
			productName = "PC";
			break;
		case 101:
			productName = "PRTer";
			break;
		case 102:
			productName = "CMRa";
			break;
		default:
			productName = "Error";
			break;
		}
		out.println( "<br>" + productName + "の紹介ページ" );
*/
		out.println( "</body></html>" );
	}
	private void showNotEnterdError( PrintWriter out ) {
		out.println( "整数をふたつ入力してください" );
	}
	private void showNotIntegerError( PrintWriter out ) {
		out.println( "整数を入力してください" );
	}

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		doPost(request, response);
	}
}
