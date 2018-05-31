package sht.practice.chapter09;

import java.math.BigDecimal;

/**
	BMIを計算するアプリケーションを作成してください。
	また、BMIの結果によって肥満度を表示するようにしてください。
	＜仕様＞
	・BMIは小数点第二位まで表示すること
	・バリデーションチェックを行うこと（空の場合と数値以外の場合）
	・MVCアーキテクチャに基づいて作成すること
	・身長・体重・BMIをプロパティに持つJavaBeansを作成すること
*/
public class Ch9No002{
	public double calcBMI( int H, int W ) {

		double
			dH = H * 0.01,
			BMI =0,
			x = 0;
		///double

		BMI = W / (dH * dH);

		BigDecimal db = new BigDecimal(BMI);
		db = db.setScale(2, BigDecimal.ROUND_HALF_UP);

		x = (BMI) % 0.01;
		System.out.println(dH);
		System.out.println(BMI);
		System.out.println(db);

		BMI -= x;

		return BMI;
	}

	public String judgeRank(Double douBMI) {
		if( douBMI < 18.5 )						return "瘦せすぎ";
		else if( 18.5 <= douBMI || douBMI < 25 )	return "標準";
		else if( 25 <= douBMI || douBMI < 30 )	return "微肥満";
		else if( 30 <= douBMI || douBMI < 35 )	return "肥満";
		else if( 35 <= douBMI || douBMI < 40 )	return "重肥満";
		else									return null;
	}
}