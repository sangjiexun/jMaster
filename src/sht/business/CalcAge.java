package sht.business;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalcAge {
	// Java APIのCalendarを用いて誕生日の計算をしている
	public int howAge( int YYYY, int MM, int DD ) {
		Calendar koyomi = Calendar.getInstance();
		koyomi.set(Calendar.YEAR, YYYY);
		koyomi.set(Calendar.MONTH, MM);
		koyomi.set(Calendar.DAY_OF_MONTH, DD);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		int now	= Integer.parseInt( sdf.format(new Date()) );
		int birth	= Integer.parseInt( sdf.format(koyomi.getTime()) );

		return (int)( (now - birth) / 10000 );
	}
}
