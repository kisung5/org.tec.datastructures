package org.tec.datastructures.graph;

import java.util.ArrayList;

public class ListGraph <T> {
	private int count = 0;
	
	private ArrayList<AddNode<T>> graph;
	
	public ListGraph () {
		graph = new ArrayList<>();
	}
	
	class AddNode<T> {
		public AddNode(T valor) {
			ArrayList<Node<T>> adejencyList = new ArrayList<>();
			Node<T> node = new Node<>(valor,count);
			count+=1;
		}
	}
	
	public ArrayList<AddNode<T>> getGraph() {
		return graph;
	}
	
}
