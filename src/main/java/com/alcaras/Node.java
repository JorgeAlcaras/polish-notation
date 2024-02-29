package com.alcaras;

public class Node {
    Object data;
    Node next; // Linea de oro

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Node(Node record) {
        this.data = record.data;
        this.next = null;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node\n Data:" + data + "\nNext=" + next + "]";
    }

}
