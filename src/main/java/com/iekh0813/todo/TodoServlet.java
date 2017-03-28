package com.iekh0813.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/todo.do")
public class TodoServlet extends HttpServlet {
    private TodoService todoService = new TodoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("todos", todoService.retrieveTodos());
        request.getRequestDispatcher("/views/todo.jsp").forward(request, response);
    }
}