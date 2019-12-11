package com.luis.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luis.model.User;
import com.luis.util.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login_do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		User user = DBUtil.verifyAccount(username, password);
		if(user!=null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("personCenter.jsp").forward(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			ServletContext application = request.getServletContext();
			int number=0;
			if(application.getAttribute("userNumber")!=null) {
				number = (int)application.getAttribute("userNumber");
			}
			number++;
			application.setAttribute("userNumber", number);
		}
		else {
			request.setAttribute("message", "Wrong username or password.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
