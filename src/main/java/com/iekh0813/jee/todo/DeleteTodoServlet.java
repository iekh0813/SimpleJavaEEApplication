package com.iekh0813.jee.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {
    /*    ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
        public TodoService todoService = (TodoService) context.getBean("todoService");
    */
    private TodoService todoService = new TodoService();

/*    @Autowired
    TodoService todoService;*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("DeleteTodoServlet: doGet");
        System.out.println("DeleteTodoServlet: todoService: " + todoService);
        todoService.deleteTodo(new Todo(request.getParameter("todo"), request.getParameter("category")));
        response.sendRedirect(request.getContextPath() + "/list-todo.do");
    }
}