package com.alcaras;

public class Stack {
    private Node top = null;
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

    public void push(Object data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public void push(Node reg) {
        Node nuevo = new Node(reg);
        nuevo.next = top;
        top = nuevo;

    }

    public Node pop() {
        Node current = null;
        if (top != null) {
            // if (!isEmpty()) {
            current = top;
            top = top.next;
            // current.sig = null;
        }
        return current;
    }

    public void show() {
        Node current = top;
        while (current != null) {
            System.out.println(current.getData());
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        boolean answer = top == null;
        return answer;
    }

    public int size() {
        int n = 0;
        Node current = top;
        while (current != null) {
            current = current.next;
            n++;
        }
        return n;
    }

    public boolean isExist(String data) {
        boolean answer = false;
        Node current = top;
        while (current != null) {
            if (current.getData() == data) {
                answer = true;
                break;
            }
            current = current.next;
        }
        return answer;
    }

    public Node peek() {
        return top;
    }

}
