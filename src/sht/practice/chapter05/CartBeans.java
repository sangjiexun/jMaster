package sht.practice.chapter05;

import java.io.Serializable;

/**
	■問題3
	問題1で作成したindex.htmlに本をカートに入れるアプリケーションを作成してください。
	＜仕様＞
	・本のタイトルと価格を持つBookクラス（JavaBeans）を作成すること
	・index.htmlで3つ以上本のリンクを作成すること（リンクにタイトルと価格のパラメータを入れること）
	・ログイン成功している状態でしか本を追加することができないこと
*/
public class CartBeans implements Serializable{
	private String name, price;


	public CartBeans() {}
	public CartBeans(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}
	public String getPrice() {
		return price;
	}


	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}