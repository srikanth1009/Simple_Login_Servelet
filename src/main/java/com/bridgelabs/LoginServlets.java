package com.bridgelabs;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;


/**
 * Servlet implementation class LoginServlets
 *
 */


@WebServlet(
		description = "Login Servlet Testing",
		urlPatterns = {"/LoginServlets"},
		initParams = {
				@WebInitParam(name="user", value="Srikanth"),
				@WebInitParam(name="pwd",value = "Srikanth@534")
		}
		)
public class LoginServlets extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get Request parameters for userId and Password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		// get servlet configuration init parameters
		String userId = getServletConfig().getInitParameter("user");
		String password = getServletConfig().getInitParameter("password");
		if (userId.equals(user) && password.equals(pwd)) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font colour=red> Either User name or Password is Wrong</font>");
			rd.include(request, response);

		}

	}
}



