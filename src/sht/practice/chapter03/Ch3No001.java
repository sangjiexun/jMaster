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
	チェックボックスのデータをGetで受け取り、チェックされたデータを表示するHTMLを返すサーブレットを作成してください
	※チェックボックスは3つ以上作成すること
*/
@WebServlet("/Ch3No001")
public class Ch3No001 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Tags tag = new Tags( "006", "03",  "001" );
		tag.begin(out);


		// チェックボックスは複数選べるので配列に格納
		String values[] = request.getParameterValues( "ani" );

		int cnt = 0;
		String checkAni = "";
		if( values == null ) {
			out.println("選択されていません");
			tag.end(out);
			return;
		}
		else {
			for (String site : values) {

				// ハイフンが余計な個所につかないようにしている。
				if(cnt > 0)checkAni += " - ";
				cnt = 0;

				switch (site) {
					case "d":
						checkAni += "DOG";
						cnt++;
						break;
					case "m":
						checkAni += "MONKEY";
						cnt++;
						break;
					case "b":
						checkAni += "BIRD";
						cnt++;
						break;
					default:
						checkAni += "不正な処理を受け取りました。";
						break;
				}
			}
		}
		out.println( checkAni +  " が選択されました。" );
		tag.end(out);
	}
}