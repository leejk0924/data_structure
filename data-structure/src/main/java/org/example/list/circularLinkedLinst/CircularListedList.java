package org.example.list.circularLinkedLinst;

import org.example.list.ListInterface;
import org.example.list.Node;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class CircularListedList<E> implements ListInterface<E> {
    private Node<E> tail;
    private int numItems;
    public final int NOT_FOUND = -12345;
    public CircularListedList() {
        numItems = 0;
        tail = new Node(-1);
        tail.next = tail;
    }

    // 첫 번째 원소는 0번 원소
    @Override
    public void add(int i, E x) {
        if (i >= 0 && i <= numItems) {
            Node<E> prevNode = getNode(i - 1);
            Node<E> newNode = new Node(x, prevNode.next);
            prevNode.next = newNode;
            if (i == numItems) {
                tail = newNode;
            }
            numItems++;
        }
    }

    private Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems) {
            Node<E> currNode = tail.next; // 더미 헤드
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        } else {
            return null;
        }
    }

    @Override
    public void append(E x) {
        Node<E> prevNode = tail;
        Node<E> newNode = new Node(x, tail.next);
        prevNode.next = newNode;
        tail = newNode;
        numItems++;
    }

    @Override
    public E remove(int i) {
        if (i >= 0 && i <= numItems) {
            Node<E> prevNode = getNode(i - 1);
            E rItem = prevNode.next.item;
            prevNode.next = prevNode.next.next;
            if (i == numItems) {
                tail = prevNode;
            }
            numItems--;
            return rItem;
        } else return null;
    }

    @Override
    public boolean removeItem(E i) {
        Node<E> currNode = tail.next;
        Node<E> prevNode;
        for (int j = 0; j < numItems; j++) {
            prevNode = currNode;
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(i) == 0) {
                prevNode.next = currNode.next;
                numItems--;
                return true;
            }
        }
        return false; // not found
    }

    @Override
    public E get(int i) {
        if (i >= 0 && i <= numItems - 1) {
            return getNode(i).item;
        } else {
            return null;
        }
    }

    @Override
    public void set(int i, E x) throws Exception {
        if (i >= 0 && i <= numItems - 1) {
            getNode(i).item = x;
        } else {
            throw new Exception("에러");
        }
    }

    @Override
    public int indexOf(E x) {
        Node<E> currNode = tail.next;
        for (int i = 0; i <= numItems; i++) {
            currNode = currNode.next;
            if(((Comparable)(currNode.item)).compareTo(x)==0) return i;
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        tail = new Node(-1);
        tail.next = tail;
    }
}
