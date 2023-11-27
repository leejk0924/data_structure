package org.example.stack;

public interface StackInterface<E> {
    void push(E newItem) throws Exception;

    E pop();

    E top();

    boolean isEmpty();

    void popALl();
}
