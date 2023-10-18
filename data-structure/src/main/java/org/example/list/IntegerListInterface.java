package org.example.list;

public interface IntegerListInterface {
    void add(int index, Integer x) throws Exception;

    void append(Integer x) throws Exception;
    Integer remove(int index);

    boolean removeItem(Integer x);

    Integer get(int index);

    void set(int index, Integer x) throws Exception;

    int indexOf(Integer x);

    int len();

    boolean isEmpty();

    void clear();
}
