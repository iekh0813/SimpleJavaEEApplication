package com.iekh0813.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    //private List<Todo> todos;

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo("Learn Web Application Development"));
        todos.add(new Todo("Learn Spring MVC"));
        todos.add(new Todo("Learn Spring Rest Services"));
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

    public List<Todo> retrieveTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        //System.out.println("addTodo before:" + todos.size());
        if (!todos.contains(todo)) {
            todos.add(todo);
            //System.out.println("addTodo after:" + todos.size());
        }
    }

    public void deleteTodo(Todo todo) {
        //System.out.println("deleteTodo before:" + todos.size());
        todos.remove(todo);
        //System.out.println("deleteTodo after:" + todos.size());
    }
}
