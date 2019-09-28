package com.zensar.controlers;
/**
 * @author Susmita Basak
 *@version 2.0
 *@creation_date 21/09/2019 5:23pm
 *@modification_date 28/09/2019 11:50pm
 *@copyright Zensar Technologies,India. All rights reserved.
 *@Description It is a controller class.
 * 
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.daos.UserDao;
import com.zensar.daos.UserDaoImpl;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

import com.zensar.services.UserService;
import com.zensar.services.UserServiceImpl;

/**
 * Servlet implementation class LoginControlers
 */
@WebServlet("/checkuser")
public class LoginControlers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//call business layer component
		private UserService userService;
		
		
		
		public void setUserService(UserService userService) {
			this.userService = userService;
		}

		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			
			UserDao userDao = new UserDaoImpl();
			UserService userService= new UserServiceImpl();
			((UserServiceImpl) userService).setUserDao(userDao);
			setUserService(userService);
		}
			
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String username = request.getParameter("username");
			String password = request.getParameter("passwd");
			User clientUser=new User();
			clientUser.setUsername(username);
			clientUser.setPassword(password);
			PrintWriter out =response.getWriter();
			//invoking business logic
			try {
				if(userService.validateUser(clientUser))
				{
					//out.println("<p>Dear"+username+"Welcome to Online Shopping</p>");
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp") ;
					rd.forward(request, response);
				}
				else
				{
					out.println("<p>Sorry ! Invalid username and password</p>");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
