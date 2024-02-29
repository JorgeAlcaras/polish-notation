package com.alcaras;

public class Stack<T> {
    private Node<T> top = null;
    private int max = 0;

    public Stack(int max) {
        this.max = max;
    }

    public Stack() {
    }

    @Override
    public String toString() {
        return "Stack [top=" + top + "]";
    }

    public void push(T data) {
        Node<T> node = new Node<T>(data);
        node.next = top;
        top = node;
    }

    public void push(Node<T> reg) {
        Node<T> nuevo = new Node<T>(reg);
        nuevo.next = top;
        top = nuevo;

    }

    public Node<T> pop() {
        Node<T> current = null;
        if (top != null) {
            // if (!isEmpty()) {
            current = top;
            top = top.next;
            // current.sig = null;
        }
        return current;
    }

    public void show() {
        Node<T> current = top;
        while (current != null) {
            System.out.println(current.getData());
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int n = 0;
        Node<T> current = top;
        while (current != null) {
            current = current.next;
            n++;
        }
        return n;
    }

    public boolean isExist(String data) {
        boolean answer = false;
        Node<T> current = top;
        while (current != null) {
            if (current.getData() == data) {
                answer = true;
                break;
            }
            current = current.next;
        }
        return answer;
    }

    public Node<T> peek() {
        return top;
    }

}
