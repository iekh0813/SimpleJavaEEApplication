package com.iekh0813.jee.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/login.do")
@Controller
public class LoginServlet extends HttpServlet {
    /*
        ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
        public LoginService loginService = (LoginService) context.getBean("loginService");
        public TodoService todoService = (TodoService) context.getBean("todoService");
    */
    @Autowired
    private LoginService loginService;

    //private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("LoginServlet: doGet");
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("LoginServlet: doPost");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean isUserValid = loginService.isUserValid(name, password.hashCode());

        if (isUserValid) {
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("loginDate", new Date());

            response.sendRedirect(request.getContextPath() + "/list-todo.do");
        } else {
            request.setAttribute("errorMessage", "Invalid credentials!!");
            request.getRequestDispatcher("/WEB-INF/views/error-login.jsp").forward(request, response);
        }
    }
}