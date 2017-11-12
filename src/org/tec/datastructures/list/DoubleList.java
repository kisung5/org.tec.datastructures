package org.tec.datastructures.list;

public class DoubleList<T> {
    private Node<T> head;
    private int size;

    public DoubleList() {
        this.head = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void add(T valor) {
        if (head == null) {
            this.head = new Node<>(valor);
            this.size++;
        } else {
            Node<T> actual = this.head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(new Node<>(valor));
            actual.getNext().setPrev(actual);
            this.size++;
        }

    }

    public void addFirst(T valor) {
        if (this.head == null) {
            this.head = new Node<>(valor);
            this.size++;
        } else {
            Node<T> temp = new Node<>(valor);
            head.setPrev(temp);
            temp.setNext(head);
            this.head = temp;
            this.size++;
        }
    }
    
    public void add(int pos, T valor) {
        Node<T> actual = this.head;
        int count = 0;
        if (pos == 0) {
            Node<T> temp = new Node<>(valor);
            head.setPrev(temp);
            temp.setNext(this.head);
            this.head = temp;
            this.size++;
        } else {
        	while (count < size) {
        		if (count == pos) {
        			Node<T> temp = new Node<>(valor);
        			temp.setNext(actual.getNext());
        			actual.getNext().setPrev(temp);
        			actual.setNext(temp);
        			temp.setPrev(actual);
        			this.size++;
        			return;
        		} else {
        			actual = actual.getNext();
        			count++;
        		}            
        	}
        }
    }

    public Node<T> get(T valor) {
        Node<T> actual = this.head;
        while (actual.getNext() != null) {
            if (actual.getValor().equals(valor)) {
                return actual;
            } else {
                actual = actual.getNext();
            }
        }
        return null;
    }
    
    public Node<T> get(int pos) {
        Node<T> actual = this.head;
        int count = 0;
        while (count < size) {
            if (count == pos) {
                return actual;
            } else {
                actual = actual.getNext();
                count++;
            }
        }
        return null;
    }

    public void remove(T valor) {
        Node<T> actual = this.head;
        
        if (actual.getValor().equals(valor)) {
            this.head = actual.getNext();
            head.setPrev(null);
            this.size--;
        } else {
        	while (actual.getNext() != null) {
        		if (actual.getNext().getValor().equals(valor)) {
        			actual.setNext(actual.getNext().getNext());
        			actual.getNext().setPrev(actual);
        			this.size--;
        			return;
        		} else {
        			actual = actual.getNext();
        		}
        	}
        }
    }
    
    public void remove(int pos) {
        Node<T> actual = this.head;
        int count = 0;
        if (pos == 0) {
            this.head = actual.getNext();
            head.setPrev(null);
        } else {
        	while (count < size) {
        		if (count == pos) {
        			actual.setNext(actual.getNext().getNext());
        			actual.getNext().setPrev(actual);
        			this.size--;
        			return;
        		} else {
        			actual = actual.getNext();
        			count++;
        		}            
        	}
        }
    }
    
    public int getSize() {
    	return this.size;
    }
    
    public Node<T> getHead() {
    	return this.head;
    }
    
}
