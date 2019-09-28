package com.zensar.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
		public void init(ServletConfig config) throws ServletException {
			// TODO Auto-generated method stub
			super.init(config);
			ServletContext context =config.getServletContext();
			String driverClassName = context.getInitParameter("JDBCdriver");
			String dburl = context.getInitParameter("jdbcUrl");
			String dbusername = context.getInitParameter("dbUser");
			String dbpassword = context.getInitParameter("dbPassword");
			//load the driver class
			
			try {
				Class.forName(driverClassName);
				context.log("JDBC Driver is loaded successfully");
				//database connection
				Connection con = DriverManager.getConnection(dburl, dbusername, dbpassword);
				context.log("Mysql database connection is established successfully");
				//create userdao object
				UserDao userDao =new UserDaoImpl();
				((UserDaoImpl)userDao).setConnection(con);
				//create userservice object
				UserService userService = new UserServiceImpl();
				((UserServiceImpl) userService).setUserdao(userDao);
				//create userservice to a servlet.
				setUserService(userService);
				context.log("UserService is set in LoginSevlet");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
