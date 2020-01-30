package ecsiteNoFramework.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecsiteNoFramework.dao.MyPageDAO;
import ecsiteNoFramework.dto.MyPageDTO;

/**
 * Servlet implementation class MyPage
 */
@WebServlet("/MyPage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<MyPageDTO> list = new ArrayList<>();
	MyPageDAO dao = new MyPageDAO();
	HttpSession session;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.session = request.getSession();


			//ログインIDが取得できなかったらエラーページに画面遷移
		if(session.getAttribute("loginId") == null){
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		String flg = (request.getParameter("delete") == null)? null : request.getParameter("delete");

		if(flg == null){
				//idとlogin_idを取り出す
			String itemId = session.getAttribute("id").toString();
			String userId  =session.getAttribute("loginId").toString();

				//Listに商品の購入履歴を代入
			list = dao.getMyPageUserInfo(itemId, userId);
			session.setAttribute("buyItemList", list);

		}else if(flg.equals("1")){

			String message = this.delete();
			session.setAttribute("buyItemList", null);
			request.setAttribute("message", message);
		}


		//myPage.jspに画面遷移
	request.getRequestDispatcher("myPage.jsp").forward(request, response);
	}


	public String delete(){
		String itemId = session.getAttribute("id").toString();
		String userId = session.getAttribute("loginId").toString();
		String message = "";
		int res = dao.buyItemHistoryDelete(itemId, userId);

		if(res > 0){
			list = null;
			message = "商品情報を正しく削除しました";
		}else
			message = "商品情報の削除に失敗しました";

		return message;
	}

}
