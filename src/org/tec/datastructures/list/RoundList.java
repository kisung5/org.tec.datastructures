package org.tec.datastructures.list;

public class RoundList<T> {
	private Node<T> head;
    private int size;

    public RoundList() {
        this.head = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void add(T valor) {
        if (head == null) {
            head = new Node<>(valor);
            head.setNext(head);
            this.size++;
        } else {
            Node<T> actual = this.head;
            while (actual.getNext() != head) {
                actual = actual.getNext();
            }
            actual.setNext(new Node<>(valor));
            actual.getNext().setNext(actual);
            this.size++;
        }

    }

    public void addFirst(T valor) {
        if (this.head == null) {
            this.head = new Node<>(valor);
            head.setNext(head);
            this.size++;
        } else {
            Node<T> temp = new Node<>(valor);
            head.setNext(temp);
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
            head.setNext(temp);
            temp.setNext(this.head);
            this.head = temp;
            this.size++;
        } else {
        	while (count < size) {
        		if (count == pos) {
        			Node<T> temp = new Node<>(valor);
        			temp.setNext(actual.getNext());
        			actual.setNext(temp);
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
        while (actual.getNext() != head) {
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
            while (actual.getNext().equals(head)) {
            	actual = actual.getNext();
            }
            actual.setNext(head.getNext());
            head = actual.getNext();
            this.size--;
        } else {
        	while (actual.getNext() != head) {
        		if (actual.getNext().getValor().equals(valor)) {
        			actual.setNext(actual.getNext().getNext());
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
        	while (actual.getNext().equals(head)) {
            	actual = actual.getNext();
            }
            actual.setNext(head.getNext());
            head = actual.getNext();
            this.size--;
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
