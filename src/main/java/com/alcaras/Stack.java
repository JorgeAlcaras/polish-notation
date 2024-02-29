package com.alcaras;

/**
 * Classic stack based on nodes.
 *
 * @param <T>
 */
public class Stack<T> {

    /**
     * Next node to be popped.
     */
    private Node<T> top = null;

    @Override
    public String toString() {
        return "Stack [top=" + top.toString() + "]";
    }

    /**
     * Add a node to the stack, creating a node based on the provided content.
     *
     * @param data Node content
     */
    public void push(T data) {
        Node<T> node = new Node<T>(data);
        node.setNext(top);
        top = node;
    }

    /**
     * Add a node to the stack.
     *
     * @param base Node
     */
    public void push(Node<T> base) {
        Node<T> node = new Node<T>(base);
        node.setNext(top);
        top = node;
    }

    /**
     * Return Returns and delete the top node.
     */
    public Node<T> pop() {
        Node<T> current = null;
        if (top != null) {
            current = top;
            top = top.getNext();
        }
        return current;
    }

    /**
     * List all nodes from the stack.
     */
    public void show() {
        Node<T> current = top;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Define if the stack is empty.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Quantity of nodes in the stack.
     */
    public int size() {
        int n = 0;
        Node<T> current = top;
        while (current != null) {
            current = current.getNext();
            n++;
        }
        return n;
    }

    /**
     * Define if the content exists in some node in the stack.
     */
    public boolean isExist(T data) {
        boolean answer = false;
        Node<T> current = top;
        while (current != null) {
            if (current.getData() == data) {
                answer = true;
                break;
            }
            current = current.getNext();
        }
        return answer;
    }

    /**
     * Returns the top node.
     */
    public Node<T> peek() {
        return top;
    }

}
