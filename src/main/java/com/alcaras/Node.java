package com.alcaras;

/**
 * Generic node for stacks or linked lists.
 *
 * @param <T>
 */
public class Node<T> {

    /**
     * Node content, it could be any type.
     */
    private final T data;

    /**
     * Define the next linked node.
     */
    private Node<T> next;

    /**
     * Build a node assigning a content.
     *
     * @param data Any kind of object.
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Create a node based on another node.
     *
     * @param node Base node.
     */
    public Node(Node<T> node) {
        this.data = node.data;
        this.next = null;
    }

    /**
     * Returns the node content, and prevent any modification to it.
     */
    public T getData() {
        return data;
    }

    /**
     * Returns the next node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Set a new next node.
     *
     * @param node
     */
    public void setNext(Node<T> node) {
        this.next = node;
    }

    @Override
    public String toString() {
        return "Node\n Data:" + data + "\nNext=" + next + "]";
    }
}
