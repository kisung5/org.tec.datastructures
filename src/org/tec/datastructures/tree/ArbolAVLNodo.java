package org.tec.datastructures.tree;

public class ArbolAVLNodo<T extends Comparable<T>> {
	public T dato; 
	public ArbolAVLNodo<T> izquierdo; 
	public ArbolAVLNodo<T> derecho; 
	public int height; 

	public ArbolAVLNodo(T dato) {
		this(dato, null, null);
	}

	public ArbolAVLNodo(T dato, ArbolAVLNodo<T> izq, ArbolAVLNodo<T> der) {
		this.dato = dato;
		this.izquierdo = izq;
		this.derecho = der;
		height = 0;
	}
}