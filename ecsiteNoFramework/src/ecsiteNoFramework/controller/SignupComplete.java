package ecsiteNoFramework.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecsiteNoFramework.dao.UserCreateDAO;

/**
 * Servlet implementation class SignupComplete
 */
@WebServlet("/SignupComplete")
public class SignupComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupComplete() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		UserCreateDAO dao = new UserCreateDAO();

		String loginId = session.getAttribute("loginId").toString();
		String loginPass = session.getAttribute("loginPass").toString();
		String userName = session.getAttribute("userName").toString();

		int result = dao.CreateUser(loginId, loginPass, userName);

		if(result >  0)
			request.getRequestDispatcher("userCreateComplete.jsp").forward(request, response);

		else {
			request.setAttribute("message", "データを挿入できませんでした");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}


	}

}
