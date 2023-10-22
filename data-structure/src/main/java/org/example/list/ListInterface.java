package org.example.list;

public interface ListInterface<E> {
    void add(int i, E x);
    void append(E x);
    E remove(int i);
    boolean removeItem(E i);
    E get(int i);
    void set(int i, E x) throws Exception;
    int indexOf(E x);
    int len();
    boolean isEmpty();
    void clear();
}
