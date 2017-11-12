package org.tec.datastructures.list;

public class Node<T> {
    private Node<T> next;
    private Node<T> prev;
    private T valor;
    
    public Node(T valor) {
        this.valor = valor;
        next = null;
        prev = null;
    }

    public Node(T valor, Node<T> next) {
        this(valor);
        this.next = next;
    }
    
    public Node(Node<T> prev, T valor, Node<T> next) {
        this(valor);
        this.next = next;
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
    
    public Node<T> getPrev() {
        return prev;
    }
    
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}

