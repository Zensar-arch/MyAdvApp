package com.zensar.controlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.models.LoginBean;

/**
 * Servlet implementation class LoginControlers
 */
@WebServlet("/checkuser")
public class LoginControlers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//retrieving request parameter value
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		
		//instantiate model
		LoginBean ob = new LoginBean();
		ob.setUsername(username);
		ob.setPassword(password);
		PrintWriter out = response.getWriter();
		//invoke business logic
		if(ob.validateUser()) {
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("Sorry!Invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
