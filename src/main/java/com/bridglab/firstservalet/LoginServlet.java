package com.bridglab.firstservalet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		description="Login servlet Testing",
		urlPatterns= {"/LoginServlet"},
		initParams= {
				@WebInitParam(name="user",value="sneha"),
				@WebInitParam(name="password",value="qwerty")
				
		}
			
			)
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
	
		String userID=getServletConfig().getInitParameter("user");
		String password=getServletConfig().getInitParameter("password");
		
		if(userID.equals(user) && password.equals(pwd))
		{
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccsess.jsp").forward(request, response);
			
		}
		else {
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out=response.getWriter();
			out.println("<font color=red> Either user name or password is wrong! </font>");
			rd.include(request, response);
		}
	}

}
