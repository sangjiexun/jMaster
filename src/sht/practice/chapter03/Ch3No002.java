package sht.practice.chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.myJava.Tags;
/*
	ラジオボタンのデータをGetで受け取り、チェックされたデータを表示するHTMLを返すサーブレットを作成してください
	※ラジオボタンは3つ以上作成すること
*/
@WebServlet("/Ch3No002")
public class Ch3No002 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// それぞれ、更新チェッカー、チャプター、課題番号の初期化
		Tags tag = new Tags( "001", "03",  "002" );

		// 第2引数はHTMLページタイトルで、課題の番号
		tag.begin(out);


		// ラジオボタンが返す値は一つだけなので変数に格納
		String values = request.getParameter( "ani" );

		String radioAni = "";
		if( values == null ) {
			out.println("選択されていません");
			tag.end(out);
			return;
		}
		else {
			switch (values) {
				case "d":
					radioAni += "DOG";
					break;
				case "m":
					radioAni += "MONKEY";
					break;
				case "b":
					radioAni += "BIRD";
					break;
				default:
					out.println( "不正な処理を受け取りました。" );
					return;
			}
		}
		out.println( radioAni +  " が選択されました。" );
		tag.end(out);
	}
}