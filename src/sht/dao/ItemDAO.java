package sht.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sht.beans.ItemBean;

public class ItemDAO {
	private Connection con;

	/**
		DBを使えるようにするメソッドを呼ぶコンストラクタ。
	*/
	public ItemDAO() throws DAOException{
		getConnection();
	}

	/**
		テーブル内のデータをJavaBeansに格納する。
	*/
	public List<ItemBean> findAll() throws DAOException {
		if(con == null) getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// アクセスしたDBでやりたい操作のSQL文を書いて実行準備している
			String sql = "SELECT * FROM item";
			st = con.prepareStatement(sql);

			// 実際にSQL文を実行している箇所（DB内の要素を変更する際はUpdate、そうでなければquery）
			rs = st.executeQuery();

			// 結果の取得と表示
			List<ItemBean> list = new ArrayList<>();
			while ( rs.next() ) {
				int code = rs.getInt("code"), price = rs.getInt("price");
				String name= rs.getString("name");

				ItemBean iBean = new ItemBean(code, price, name);
				list.add(iBean);
			}
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("要素取得失敗");
		}
		finally {
			try {
				// 領域開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("領域解放失敗");
			}
		}
	}

	/** DBを使えるようにするための一連の処理（使えるようになったかの確認まで）*/
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
		} catch (Exception e) {
			throw new DAOException("接続失敗");
		}
	}
	private void close() throws SQLException{
		if(con != null) {
			con.close();
			con = null;
		}
	}



	// ◆◆◆◆◆ここから新規さん
	/**
		価格の昇順降順で表示する。
	*/
	public List<ItemBean> sortPrice(boolean isAscending) throws DAOException{
		if(con == null) getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		// アクセスしたDBでやりたい操作のSQL文を書いて実行準備している
			String sql;
			if(isAscending)		sql = "SELECT * FROM item ORDER BY price";
			else				sql = "SELECT * FROM item ORDER BY price desc";

			st = con.prepareStatement(sql);
		// 実際にSQL文を実行している箇所（DB内の要素を変更する際はUpdate、そうでなければquery）
			rs = st.executeQuery();
		// 結果の取得と豆格納
			List<ItemBean> list = new ArrayList<>();
			while ( rs.next() ) {
				int code = rs.getInt("code"), price = rs.getInt("price");
				String name= rs.getString("name");

				ItemBean iBean = new ItemBean(code, price, name);
				list.add(iBean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("要素取得失敗");
		}
		finally {
			try {
				// 領域開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("領域解放失敗");
			}
		}
	}

	/**
		新しいデータを格納している。
	*/
	public int addItem( String name, int price )  throws DAOException{
		if(con == null) getConnection();

		PreparedStatement st = null;
		try {
		// アクセスしたDBでやりたい操作のSQL文を書いて実行準備している
			String sql = "INSERT INTO item( name, price ) VALUES( ?, ? )";
			st = con.prepareStatement(sql);

			st.setString(1, name);
			st.setInt(2, price);
		// 実際にSQL文を実行している箇所（DB内の要素を変更する際はUpdate、そうでなければquery）
			int rows = st.executeUpdate();
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("要素取得失敗");
		}
		finally {
			try {
				// 領域開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("領域解放失敗");
			}
		}
	}


	/**
		指定した価格以下のデータを表示。
	*/
	public List<ItemBean> findByPrice(int lePrice) throws DAOException{
		if(con == null) getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		// アクセスしたDBでやりたい操作のSQL文を書いて実行準備している
			String sql = "SELECT * FROM item WHERE price <= ?";
			st = con.prepareStatement(sql);

			st.setInt(1, lePrice);
		// 実際にSQL文を実行している箇所（DB内の要素を変更する際はUpdate、そうでなければquery）
			rs = st.executeQuery();
		// 結果の取得と表示
			List<ItemBean> list = new ArrayList<>();
			while ( rs.next() ) {
				int code = rs.getInt("code"), price = rs.getInt("price");
				String name= rs.getString("name");

				ItemBean iBean = new ItemBean(code, price, name);
				list.add(iBean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("要素取得失敗");
		}
		finally {
			try {
				// 領域開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("領域解放失敗");
			}
		}
	}

	/**
		指定行のデータを削除。
	*/
	public int deleteByPrimaryKey(int key)  throws DAOException{
		if(con == null) getConnection();

		PreparedStatement st = null;
		try {
			// アクセスしたDBでやりたい操作のSQL文を書いて実行準備している
			String sql = "DELETE FROM item WHERE code=?";
			st = con.prepareStatement(sql);

			st.setInt(1, key);

			// 実際にSQL文を実行している箇所（DB内の要素を変更する際はUpdate、そうでなければquery）
			int rows = st.executeUpdate();

			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("要素取得失敗");
		}
		finally {
			try {
				// 領域開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("領域解放失敗");
			}
		}
	}
}