package com.iekh0813.todo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {
    ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
    private TodoService todoService = (TodoService) context.getBean("todoService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //System.out.println(request.getParameter("todo"));
        todoService.deleteTodo(new Todo(request.getParameter("todo")));
        response.sendRedirect("/todo.do");
    }
}