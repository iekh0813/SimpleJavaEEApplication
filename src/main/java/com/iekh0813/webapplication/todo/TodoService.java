package com.iekh0813.webapplication.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    //private List<Todo> todos;

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo("Learn Web Application Development", "Study"));
        todos.add(new Todo("Learn Spring MVC", "Study"));
        todos.add(new Todo("Learn Spring Rest Services", "Study"));
    }

/*
    public TodoService(List<Todo> todos) {
        this.todos = todos;
    }
*/

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        TodoService.todos = todos;
    }

    List<Todo> retrieveTodos() {
        return todos;
    }

    void addTodo(Todo todo) {
        //System.out.println("addTodo before:" + todos.size());
        if (!todos.contains(todo)) {
            todos.add(todo);
            //System.out.println("addTodo after:" + todos.size());
        }
    }

    void deleteTodo(Todo todo) {
        //System.out.println("deleteTodo before:" + todos.size());
        todos.remove(todo);
        //System.out.println("deleteTodo after:" + todos.size());
    }
}
