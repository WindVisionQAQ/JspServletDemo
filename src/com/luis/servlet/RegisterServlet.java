package com.luis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luis.util.DBUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register_do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		boolean isSuccess = DBUtil.addUser(username, password, age, sex);
		if(isSuccess) {
			request.setAttribute("message", "Register success.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message", "Username exists. Try again.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
