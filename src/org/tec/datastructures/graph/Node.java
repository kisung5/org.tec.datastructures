package org.tec.datastructures.graph;

public class Node <T> {
	
	private int rep;
	private T valor;
	
	public Node(T valor, int rep) {
		this.valor = valor;
		this.rep = rep;
	}
	
	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
	
	public int getRep() {
		return rep;
	}
	
	public void setRep(int rep) {
		this.rep = rep;
	}
}
