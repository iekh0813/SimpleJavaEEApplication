package com.iekh0813.webapplication.todo;

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
        System.out.println("AddTodoServlet: doPost");
        System.out.println("AddTodoServlet: request.getContextPath() = " + request.getContextPath());
        String newTodo = request.getParameter("todo");
        String categoryTodo = request.getParameter("category");
        if (StringUtils.isNotEmpty(newTodo)) {
            todoService.addTodo(new Todo(newTodo, categoryTodo));
        }
        System.out.println("AddTodoServlet: request.getContextPath() = " + request.getContextPath());
        response.sendRedirect(request.getContextPath() + "/list-todo.do");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("AddTodoServlet: doGet");
        request.getRequestDispatcher("/views/new-todo.jsp").forward(request, response);
    }
}