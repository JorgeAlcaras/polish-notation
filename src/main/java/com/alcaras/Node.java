package com.alcaras;

public class Node<T> {
    T data;
    Node<T> next; // Linea de oro

    public Node() {
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node(Node<T> record) {
        this.data = record.data;
        this.next = null;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node\n Data:" + data + "\nNext=" + next + "]";
    }

}
