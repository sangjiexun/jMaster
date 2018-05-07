package sht.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.beans.PersonBean;
import sht.business.CalcAge;

@WebServlet("/ReceiveAgeSer")
public class ReceiveAgeSer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 入力値、日本語に対応させている
		request.setCharacterEncoding("UTF-8");


		// 入力値の取得
		String	serName	= request.getParameter("name"),
				serYYYY	= request.getParameter("yyyy"),
				serMM	= request.getParameter("mm"),
				serDD	= request.getParameter("dd");


		// 値が入力されているか（未入力ではないか）の確認とエラー処理
		if(		serYYYY == null || serYYYY.length() == 0 ||
				serMM == null || serMM.length() == 0 ||
				serDD == null || serDD.length() == 0
		) {
			// エラーメッセージを外部JSPで利用できるようにする為の一連の処理
			request.setAttribute( "noneValueMessage", "未入力！！");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request, response);
			return;
		}


		// 整数型への変換とエラー処理
		int serYYYYInt, serMMInt, serDDInt;
		try {
			serYYYYInt	= Integer.parseInt(serYYYY);
			serMMInt	= Integer.parseInt(serMM);
			serDDInt		= Integer.parseInt(serDD);
		} catch (NumberFormatException e) {
			// エラーメッセージを外部JSPで利用できるようにする為の一連の処理
			request.setAttribute( "illegalValueMessage", "整数に変換できない！！！！");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request, response);
			return;
		}


		// 外部Javaファイル内のクラスで計算をしてもらい、結果を受け取る
		CalcAge ca = new CalcAge();
		int age = ca.howAge( serYYYYInt, serMMInt, serDDInt );


		// JavaBeansに結果等を格納し、外部JSPで利用できるようにする
		PersonBean pb = new PersonBean( serName, age );
		request.setAttribute( "person", pb );
		RequestDispatcher rd = request.getRequestDispatcher("/showAge.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}