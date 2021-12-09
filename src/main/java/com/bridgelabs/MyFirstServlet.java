package com.bridgelabs;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class MyFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3> Hello World My First Servlet </h3>");
        out.close();
    }
}
