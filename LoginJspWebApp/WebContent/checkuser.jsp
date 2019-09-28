
<%
	String username = request.getParameter("username");
	String password = request.getParameter("passwd");
	//business logic
	if(username!=null && password!=null && username.equals("susmita") && password.equals("hello"))
	{
		//pageContext.forward("Welcome.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
		
	}
	else
	{
		out.println("Invalid username/password");
		pageContext.include("login.jsp");
	}


%>