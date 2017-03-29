package com.iekh0813.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/list-todo.do")
public class ListTodoServlet extends HttpServlet {
    /*    ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
        private TodoService todoService = (TodoService) context.getBean("todoService");
    */
    private TodoService todoService = new TodoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("ListTodoServlet: " + todoService);
        request.setAttribute("todos", todoService.retrieveTodos());
        request.getRequestDispatcher("/views/list-todos.jsp").forward(request, response);
    }
}