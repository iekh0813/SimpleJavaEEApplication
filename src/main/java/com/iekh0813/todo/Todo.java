package com.iekh0813.todo;

import java.util.Objects;

public class Todo {
    private String name;

    public Todo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //System.out.println(this.getName() + ":" + getClass());
        //System.out.println(((Todo) o).getName() + ":" + o.getClass());

        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;

        //System.out.println(this.getName() + "-" + ((Todo) o).getName() + ":" + Objects.equals(name, todo.name));
        return Objects.equals(name, todo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
