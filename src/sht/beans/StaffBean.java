package sht.beans;

import java.io.Serializable;

public class StaffBean implements Serializable{
	// 名前・年齢・部署
	private String name;
	private int age;
	private String department;



	public StaffBean() {}
	public StaffBean( String name, int age,String department ) {
		this.name = name;
		this.age = age;
		this.department = department;
	}



	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getDepartment() {
		return department;
	}



	// 書き換える際にも利用するのでコンストラスクタとは別で用意する
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
