package sth.DBLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sht.dao.DAOException;

public class AppDAO {
	Connection con;

	/**
		DBを使えるようにするための一連の処理（使えるようになったかの確認まで）
	*/
	private void getConnection() throws DAOException{
		try {
			// JDBCを使えるようにするよ（JDBCのパスの指定）
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 使いたいDBの場所、使うユーザーのユーザ名・パスワードを用意する
			String url = "jdbc:mysql://localhost/sample2?serverTimezone=UTC&useSSL=false";
			String user = "student";
			String pass = "himitu";

			// ユーザー名・パスワードを使って任意のURLの先のDBにアクセス（ログイン）する
			con = DriverManager.getConnection( url, user, pass );
		}
		catch (Exception e) {
			// DB接続失敗時の処理
			throw new DAOException("接続失敗");
		}
	}
	/**
		DBを操作してユーザー情報を取得
	*/
	protected LoginBean userInfo( String userName, String password/*, HttpServletResponse response*/ ) throws DAOException, IOException{
//		PrintWriter out = response.getWriter();

		// DBにアクセスする。
		if(con == null) getConnection();


		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = null;


		try {
			// userテーブルの取得命令実行
			sql = "SELECT * FROM user WHERE name = '" + userName + "' AND pass = '" + password + "';";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();


			// DBのユーザー情報を取得
			// DBのユーザー情報を格納するためのリスト
			rs.next();
			String name = rs.getString("name"), pass = rs.getString("pass");
			LoginBean lb = new LoginBean(name, pass);
			return lb;
		}
		catch (Exception e) {
			// DBからデータを持ってくるのに失敗した際の処理
			e.printStackTrace();
			throw new DAOException("要素取得失敗");
		}
		finally {
			try {
				// 領域開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			}
			catch (Exception e) {
				// 領域開放に失敗・クローズできない（オブジェクトが実行されてない）場合のエラー処理
				throw new DAOException("領域解放失敗");
			}
		}
	}
	private void close() throws SQLException{
		if(con != null) {
			con.close();
			con = null;
		}
	}
}