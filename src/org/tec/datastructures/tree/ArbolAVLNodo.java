package org.tec.datastructures.tree;

public class ArbolAVLNodo {
	public Comparable<?> dato; // el dato del nodo
	public ArbolAVLNodo izquierdo; // hijo izquierdo
	public ArbolAVLNodo derecho; // hijo derecho
	public int height; // altura

	// Constructors
	public ArbolAVLNodo(Comparable<?> dato) {
		this(dato, null, null);
	}

	public ArbolAVLNodo(Comparable<?> dato, ArbolAVLNodo izq, ArbolAVLNodo der) {
		this.dato = dato;
		this.izquierdo = izq;
		this.derecho = der;
		height = 0;
	}
}