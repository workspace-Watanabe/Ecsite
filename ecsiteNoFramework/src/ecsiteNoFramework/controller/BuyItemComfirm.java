package ecsiteNoFramework.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecsiteNoFramework.dao.BuyItemCompleteDAO;

/**
 * Servlet implementation class BuyItemComfirm
 */
@WebServlet("/BuyItemComfirm")
public class BuyItemComfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

			//itemIdの代入
		String id = session.getAttribute("id").toString();
			//合計金額の代入
		String totalPrice = session.getAttribute("total_price").toString();
			//個数の代入
		String count = session.getAttribute("count").toString();
			//ログインIDの代入
		String loginId = session.getAttribute("loginId").toString();
			//支払い方法の代入
		String pay = session.getAttribute("pay").toString();

		BuyItemCompleteDAO dao = new BuyItemCompleteDAO();
		int result = dao.buyItemInfo(id, totalPrice, count, loginId, pay);

		String next;
		if(result > 0){
			next="buyItemComplete.jsp";
		}else{
			request.setAttribute("message", "エラーが発生しました");
			next="error.jsp";
		}

		request.getRequestDispatcher(next).forward(request, response);
	}

}
