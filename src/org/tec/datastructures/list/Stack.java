package org.tec.datastructures.list;

public class Stack <T> {
	private LinkedList<T> list;
	
	public Stack() {
		list = new LinkedList<>();
	}
	
	public void push(T element) {
		list.addFirst(element);
	}
	
	public Node<T> peek() {
		return list.get(0);
	}
	
	public Node<T> pop() {
		return list.removeFirst();
	}

}
