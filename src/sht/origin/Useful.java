package sht.origin;

public class Useful{
	/**
		文字列が空、NULLの場合NULLを返す。
	*/
	public String judgeNull( String value ){
		if( value.length() == 0 || value == null ) return null;
		else return value;
	}
	/**
		文字列が空の場合、偽を返す。
	*/
	public boolean isNull( String value ){
		if(value == null ) return false;
		else return true;
	}
	/**
		オブジェクトが空の場合、偽を返す。
	 */
	public boolean isNull( Object value ){
		if(value == null ) return false;
		else return true;
	}
}