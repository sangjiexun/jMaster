package sht.practice.chapter08;

import java.io.Serializable;

/**
	本情報を格納するJavaBeansを作成してください
	no004.jspからformで「タイトル」と「価格」をパラメータとしてサーブレットへ渡してください
	サーブレットで受け取ったデータをJavaBeansに格納し、JavaBeansをリクエストパラメータへ格納してください
	リクエストパラメータへ格納後、book.jspへフォワードしてください。
	book.jsp内でELを使用してタイトルと価格を表示させてください
*/
public class BookBeans implements Serializable{
	private String title, price;


	public BookBeans(String title, String price) {
		this.title = title;
		this.price = price;
	}


	public String getTitle() {
		return title;
	}
	public String getPrice() {
		return price;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}