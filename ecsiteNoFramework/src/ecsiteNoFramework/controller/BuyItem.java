package ecsiteNoFramework.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BuyItem")
public class BuyItem extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public BuyItem() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//購入数
		String count = request.getParameter("count");

			//sessionの呼び出し
		HttpSession session = request.getSession();
			//sessionに購入数を登録
		session.setAttribute("count", count);

			//整数型の購入数を宣言
		int intCount = Integer.parseInt(count);
			//sessionから値段を取り出す
		int intPrice = Integer.parseInt(session.getAttribute("buyItem_price").toString());

			//sessionに合計金額を登録
		session.setAttribute("total_price", intCount * intPrice);

	;
			//支払い方法
		String pay = request.getParameter("pay");
			//支払い方法の確認
		String payment =(pay.equals("1"))? "現金払い"
						:(pay.equals("2"))? "クレジットカード" : "ERROR";

			//sessionに支払い方法の登録
		session.setAttribute("pay",payment);
			//画面遷移
		request.getRequestDispatcher("buyItemConfirm.jsp").forward(request, response);
	}

}
