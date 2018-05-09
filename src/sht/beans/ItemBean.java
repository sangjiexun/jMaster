package sht.beans;

import java.io.Serializable;
/*
	DB実習用Beans
*/
public class ItemBean implements Serializable {
	// DBと同じ名前でなくてもよい（同じ方が無難）
	private int code, price;
	private String name;


	public ItemBean() {}
	public ItemBean(int code, int price, String name) {
		this.code = code;
		this.price = price;
		this.name = name;
	}


	public int getCode() {
		return code;
	}
	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}


	public void setCode(int code) {
		this.code = code;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
}