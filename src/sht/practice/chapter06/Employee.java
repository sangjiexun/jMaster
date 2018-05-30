package sht.practice.chapter06;

public class Employee {
	private String name;
	private int num;


	public Employee() {}
	public Employee(String name, int num) {
		this.name = name;
		this.num = num;
	}


	public String getName() {
		return name;
	}
	public int getNum() {
		return num;
	}


	public void setName(String name) {
		this.name = name;
	}
	public void setNum(int num) {
		this.num = num;
	}
}