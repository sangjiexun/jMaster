package sth.DBLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.dao.DAOException;

/**


	DBの取り方を変える

	◆JSPで入力を求める。
	◇JSPで入力されたユーザー名・パスワードを受け取る。
	◇DBにアクセスする。
	◇DBのユーザー情報を取得。
	◇ユーザー情報（DB）と入力値（JSP）の比較。
	◇一致。
	◇JSPのマイページに遷移。
	◆マイページ表示。
*/
@WebServlet("/AppServlet_01")
public class AppServlet_01 extends HttpServlet {
	Connection con;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			// JSPで入力されたユーザー名・パスワードを受け取る。
			String userName	= request.getParameter("userName");
			String password	= request.getParameter("password");

			// DBのユーザー情報を取得。
			List<LoginBean> userInfoDB = userInfo();

			for (LoginBean loginBean : userInfoDB) {
				out.println(loginBean.getUserName() + " + br<br>");
				out.println(loginBean.getPassword() + " + br<br><br>");
			}

			for (int i = 0; i < userInfoDB.size(); i++) {
				if(		userName.equals( userInfoDB.get(i).getUserName() ) &&
						password.equals( userInfoDB.get(i).getPassword() )
				/* if条件式ここまで */) {

					request.setAttribute( "userName", userInfoDB.get(i).getUserName() );
					request.setAttribute( "password", userInfoDB.get(i).getPassword() );
					RequestDispatcher rd = request.getRequestDispatcher("/loginJSP/myPage.jsp");
					rd.forward(request, response);
				}
			}

//			if(		userName.equals( userInfoDB.get(0).getUserName() ) &&
//					password.equals( userInfoDB.get(0).getPassword() )
//			/* if条件式ここまで */) {
//
//				request.setAttribute( "userName", userInfoDB.get(0).getUserName() );
//				request.setAttribute( "password", userInfoDB.get(0).getPassword() );
//				RequestDispatcher rd = request.getRequestDispatcher("/loginJSP/myPage.jsp");
//				rd.forward(request, response);
//			}
		} catch (Exception e) {
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

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
		} catch (Exception e) {
			throw new DAOException("接続失敗");
		}
	}
	/**
		DBを操作してユーザー情報を取得
	*/
	private List<LoginBean> userInfo() throws DAOException{
		// DBにアクセスする。
		if(con == null) getConnection();


		PreparedStatement st = null;
		ResultSet rs = null;


		try {
			// userテーブルの取得命令実行
			String sql = "SELECT * FROM user";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();


			// DBのユーザー情報を取得
			// DBのユーザー情報を格納するためのリスト
			List<LoginBean> list = new ArrayList<>();
			while ( rs.next() ) {
				String userName = rs.getString("name"), password = rs.getString("pass");

				LoginBean lb = new LoginBean(userName, password);
				list.add(lb);
			}
			return list;
		}
		catch (Exception e) {
//			e.printStackTrace();
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
	private void close() throws SQLException{
		if(con != null) {
			con.close();
			con = null;
		}
	}
}