package ecsiteNoFramework.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecsiteNoFramework.dao.BuyItemDAO;
import ecsiteNoFramework.dao.LoginDAO;
import ecsiteNoFramework.dto.BuyItemDTO;
import ecsiteNoFramework.dto.LoginDTO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loginId = request.getParameter("loginId");
		String loginPass = request.getParameter("loginPass");
		String result = "";

		LoginDTO dto = null;
		LoginDAO dao = new LoginDAO();
		dto = dao.getLoginUser(loginId,loginPass);


		if(dto.getLoginId()== null
				|| dto.getLoginPass() == null){
			request.setAttribute("message", "ログインできませんでした");
			result = "error.jsp";
		}
		else if(dto.getLoginId().equals(loginId)
				&& dto.getLoginPass().equals(loginPass)){
			request.setCharacterEncoding("utf-8");

			request.setAttribute("loginPass", dto.getLoginPass());
			BuyItemDAO buyItemdao = new BuyItemDAO();
			BuyItemDTO buyItemdto = buyItemdao.getBuyItemInfo();

			HttpSession session = request.getSession();
			session.setAttribute("loginId", dto.getLoginId());
			session.setAttribute("id", buyItemdto.getId());
			session.setAttribute("buyItem_name", buyItemdto.getItemName());
			session.setAttribute("buyItem_price", buyItemdto.getItemPrice());

			result = "buyItem.jsp";
		}else{
			request.setAttribute("message", "予期せぬエラーが発生しました");
			result = "error.jsp";
		}
		request.getRequestDispatcher(result).forward(request, response);


	}

}
