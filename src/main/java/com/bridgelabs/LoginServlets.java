package com.bridgelabs;
import java.lang.NullPointerException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
				@WebInitParam(name="password",value = "Srikanth@534")
		}
		)
public class LoginServlets extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws NullPointerException,ServletException, IOException {
		// get Request parameters for userId and Password
		//Regex pattern for user name
		String user = request.getParameter("user");
		String NAME_PATTERN = "^[A-Z]{1}[a-z]{3,}$";
		//Regex pattern for password
		String pwd = request.getParameter("pwd");
		String PASSWORD = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*?&]{8,}$";
		// get servlet configuration init parameters
		String userId = getServletConfig().getInitParameter("user");
		String password = getServletConfig().getInitParameter("password");
		if (userId.equals(user) && userId.matches(NAME_PATTERN)&&password.equals(pwd)&&password.matches(PASSWORD)) {
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



