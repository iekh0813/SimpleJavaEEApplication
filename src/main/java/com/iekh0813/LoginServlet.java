package com.iekh0813;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UserValidationService service = new UserValidationService();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (service.isUserValid(name, password)) {
            request.setAttribute("name", name);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/views/welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid credentials!!");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
    }
}