package com.bridgelabs;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Srikanth"),
                @WebInitParam(name = "password", value = "abcd@123")
        }
)

public class LoginServlet extends HttpServlet {
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