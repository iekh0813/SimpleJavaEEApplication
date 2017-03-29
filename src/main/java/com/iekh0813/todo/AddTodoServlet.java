package com.iekh0813.todo;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {
    /*    ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
        public TodoService todoService = (TodoService) context.getBean("todoService");
    */
    private TodoService todoService = new TodoService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("AddTodoServlet: " + todoService);
        String newTodo = request.getParameter("todo");
        String categoryTodo = request.getParameter("category");
        if (StringUtils.isNotEmpty(newTodo)) {
            todoService.addTodo(new Todo(newTodo, categoryTodo));
        }
        response.sendRedirect("/list-todo.do");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/new-todo.jsp").forward(request, response);
    }
}