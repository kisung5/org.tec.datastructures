package org.tec.datastructures.list;

public class Queue <T> {
	private LinkedList<T> list;
	
	public Queue() {
		list = new LinkedList<>();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void enqueue(T element) {
		list.add(element);
	}
	
	public Node<T> dequeue() {
		return list.removeFirst();
	}
	
	public Node<T> peek() {
		return list.getHead();
	}

}
