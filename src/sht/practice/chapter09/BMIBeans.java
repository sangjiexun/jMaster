package sht.practice.chapter09;

import java.io.Serializable;

/**
	BMIを計算するアプリケーションを作成してください。
	また、BMIの結果によって肥満度を表示するようにしてください。
	＜仕様＞
	・BMIは小数点第二位まで表示すること
	・バリデーションチェックを行うこと（空の場合と数値以外の場合）
	・MVCアーキテクチャに基づいて作成すること
	・身長・体重・BMIをプロパティに持つJavaBeansを作成すること
*/
public class BMIBeans implements Serializable{
	public int H, W;
	public double BMI;


	public BMIBeans(int H, int W, double BMI) {
		this.H = H;
		this.W = W;
		this.BMI = BMI;
	}


	public int getH() {
		return H;
	}
	public int getW() {
		return W;
	}
	public double getBMI() {
		return BMI;
	}


	public void setH(int H) {
		this.H = H;
	}
	public void setW(int W) {
		this.W = W;
	}
	public void setBMI(double BMI) {
		this.BMI = BMI;
	}
}