package sht.myJava;
import java.io.PrintWriter;

public class Tags {
	String ver;
	String chapter;
	String No;

	public Tags( String ver, String chapter, String No ) {
		this.ver = ver;
		this.chapter = chapter;
		this.No = No;
	}

	public void begin( PrintWriter out ) {
		out.println( "<!DOCTYPE html>" );
		out.println( "<html><head><meta charset=\"UTF-8\"><title>問題" + this.No + "</title></head>" );
		out.println( "<body><div style=\"padding: 10px; width: 600px; background: #CFC; font: 12pt Meiryo;\">" );
		out.println( "<div style=\"padding: 10px; background: #FFC; text-align: center;\">" );
	}
	public void end( PrintWriter out ) {
		out.println( "</div>FOOTER_ver." + this.ver + "<br><a href=\"practice/chapter" + this.chapter + "/no" + this.No + ".html\">BACK</a>" );
		out.println( "</div></body></html>" );
	}
	public void emphasis( PrintWriter out, int text ) {
		out.println( "<span style = \"font-size: 24pt;\">" + text + "</span>" );
	}
	public void emphasis( PrintWriter out, String text ) {
		out.println( "<span style = \"font-size: 24pt;\">" + text + "</span>" );
	}
}
