package sht.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.beans.ItemBean;
import sht.dao.DAOException;
import sht.dao.ItemDAO;

@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			// ◆◆◆◆◆ フォームから投げられた情報を取得
			String action = request.getParameter("action");

			// ◆◆◆◆◆
			ItemDAO dao = new ItemDAO();

			// ◆◆◆◆◆テーブルの全体表示
			if( action == null || action.length() == 0 ) {
				List<ItemBean> list = dao.findAll();

				request.setAttribute( "items", list);
				gotoPage(request, response, "/Java_11_html/showItem.jsp");
			}


			// ◆◆◆◆◆追加処理
			else if( action.equals("add") ) {
				String name = request.getParameter("name");
				int price = Integer.parseInt( request.getParameter("price") );

				dao.addItem(name, price);

				List<ItemBean> list = dao.findAll();

				request.setAttribute( "items", list);
				gotoPage(request, response, "/Java_11_html/showItem.jsp");
			}


			// ◆◆◆◆◆並替処理
			else if( action.equals("sort") ) {
				String key = request.getParameter("key");

				List<ItemBean> list = dao.findAll();

				if( key.equals("price_asc") )	list = dao.sortPrice(true);
				else						list = dao.sortPrice(false);

				request.setAttribute( "items", list);
				gotoPage(request, response, "/Java_11_html/showItem.jsp");
			}


			// ◆◆◆◆◆検索処理
			else if( action.equals("search") ) {
				int price = Integer.parseInt( request.getParameter("price") );

				List<ItemBean> list = dao.findByPrice(price);

				request.setAttribute( "items", list);
				gotoPage(request, response, "/Java_11_html/showItem.jsp");
			}


			// ◆◆◆◆◆削除処理
			else if( action.equals("delete") ) {
				int code = Integer.parseInt( request.getParameter("code") );
				dao.deleteByPrimaryKey(code);

				List<ItemBean> list = dao.findAll();

				request.setAttribute( "items", list);
				gotoPage(request, response, "/Java_11_html/showItem.jsp");
			}
			else {
				request.setAttribute( "message", "操作を上手く受け取れませんでした。");
				gotoPage(request, response, "/Java_11_html/errInternal.jsp");
			}
		}
		catch(DAOException e ) {
			e.printStackTrace();
			request.setAttribute( "errorMessage", "DAOでエラー");
			RequestDispatcher rd = request.getRequestDispatcher("/Java_11_html/errInternal.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// ◆◆◆◆◆
	/**
		受け取ったデータを指定のJSPで表示するための処理。
	*/
	protected void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}