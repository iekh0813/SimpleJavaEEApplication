package com.iekh0813.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo("Learn Web Application Development"));
        todos.add(new Todo("Learn Spring MVC"));
        todos.add(new Todo("Learn Spring Rest Services"));
    }

    public List<Todo> retrieveTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        if (!todos.contains(todo)) {
            todos.add(todo);
        }
    }

    public void deleteTodo(Todo todo) {
        todos.remove(todo);
    }
}
