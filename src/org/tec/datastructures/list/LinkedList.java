package org.tec.datastructures.list;

public class LinkedList <T> {
    private Node<T> head;
    private int size;
    
    public LinkedList() {
        this.head = null;
    }
    /**
     * 
     * @return
     * Retorna true o false si la lista esta vacia.
     */
    public boolean isEmpty() {
        return this.head == null;
    }
    /**
     * 
     * @param valor
     * Parametro con el que se agrega un elemento a la lista tipo T.
     */
    public void add(T valor) {
        if (this.head == null) {
            this.head = new Node<>(valor);
            this.size++;
        } else {
            Node<T> actual = this.head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(new Node<T>(valor));
            this.size++;
        }
    }
    /**
     * 
     * @param valor
     * Recibe un valor tipo T y lo agrega al inicio de la lista enlazada.
     */
    public void addFirst(T valor) {
        if (this.head == null) {
            this.head = new Node<>(valor);
            this.size++;
        } else {
            Node<T> temp = new Node<>(valor);
            temp.setNext(this.head);
            this.head= temp;
            this.size++;
        }
    }
    /**
     * 
     * @param pos
     * Recibe un parametro entero pos para buscar en la lista enlazada e 
     * insertar en esa posicion.
     * @param valor 
     * El valor a ingresar en la pos.
     */
    public void add(int pos, T valor) {
        Node<T> actual = this.head;
        for (int i = 0; i<size ; i++) {
            if (pos == i && i == 0) {
                Node<T> temp = new Node<>(valor);
                temp.setNext(this.head);
                this.head= temp;
                this.size++;
                return;
            } else if (pos == i) {
                Node<T> temp = new Node<>(valor);
                temp.setNext(actual.getNext());
                actual.setNext(temp);
                this.size++;
                return;
            } else {
                actual = actual.getNext();
            }            
        }
        
    }
    /**
     * 
     * @param pos
     * El parametro pos busca en Nodo T con ese indice.
     * @return
     * Da el nodo de la poscion seleccionada.
     */
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
    /**
     * 
     * @param pos 
     * Elimina el Nodo T de la lista con la int pos, este pos es el indice.
     */
    public void remove(int pos) {
        Node<T> actual = this.head;
        int count = 0;
        while (count < size) {
            if (pos == 0) {
                this.head = actual.getNext();
                this.size--;
                return; 
            } else if (count == (pos - 1)) {
                actual.setNext(actual.getNext().getNext());
                this.size--;
                return;
            } else {
                actual = actual.getNext();
                count++;
            }            
        }
    }
    
    public void remove(T valor) {
    	Node<T> actual = this.head;
    	if (actual.getValor().equals(valor)) {
    		this.head = actual.getNext();
    		this.size--;
    	} else {			
    		while (actual.getNext() != null) {
    			if(actual.getNext().getValor().equals(valor)) {
    				actual.setNext(actual.getNext().getNext());
    				this.size--;
    				return;
    			} else {
    				actual = actual.getNext();
    			}
    		}
    	}
    }
    
    public Node<T> removeFirst() {
    	Node<T> temp = this.head;
    	this.head = head.getNext();
    	return temp;
    }
    
    public Node<T> removeLast() {
    	Node<T> temp;
    	Node<T> actual = head;
    	while (actual.getNext().getNext() != null) {
    		actual = actual.getNext();
    	}
    	temp = actual.getNext();
    	actual.setNext(null);
    	return temp;
    }
    
    public int getSize() {
    	return this.size;
    }
    
    public Node<T> getHead() {
    	return this.head;
    }

}  