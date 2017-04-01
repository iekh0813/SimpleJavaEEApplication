package com.iekh0813.jee.todo;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/list-todo.do")
public class ListTodoServlet extends HttpServlet {
    Logger logger = Logger.getLogger(ListTodoServlet.class);
    /*    ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
        private TodoService todoService = (TodoService) context.getBean("todoService");
    */
    //
    private TodoService todoService = new TodoService();
/*
    @Autowired
    TodoService todoService;
*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("ListTodoServlet: doGet");
        System.out.println("ListTodoServlet: todoService: " + todoService);

        logger.debug("ListTodoServlet: doGet");
        logger.debug("ListTodoServlet: todoService: " + todoService);

        request.setAttribute("todos", todoService.retrieveTodos());
        request.getRequestDispatcher("/WEB-INF/views/list-todos.jsp").forward(request, response);
    }
}