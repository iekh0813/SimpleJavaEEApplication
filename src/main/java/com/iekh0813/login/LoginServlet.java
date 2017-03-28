package com.iekh0813.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean isUserValid = loginService.isUserValid(name, password);

        if (isUserValid) {
/*
            request.setAttribute("name", name);
            request.setAttribute("todos", todoService.retrieveTodos());
            request.getRequestDispatcher("/views/welcome.jsp").forward(request, response);
*/
            response.sendRedirect("/todo.do");
        } else {
            request.setAttribute("errorMessage", "Invalid credentials!!");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
    }
}