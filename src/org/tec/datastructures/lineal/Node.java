package org.tec.datastructures.lineal;

public class Node <T>{
	private Node right;
	private Node left;
	private T valor;

	public Node (T valor) {
		this.valor = valor;
	}
	
	public Node (T valor, Node right) {
		this.valor = valor;
		this.right = right;
	}
	
	public Node (T valor, Node right, Node left) {
		this.valor = valor;
		this.right = right;
		this.left = left;
	}
	
	public T getValor() {
		return valor;
	}
	
	
}
