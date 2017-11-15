package org.tec.datastructures.list;

public class ArbolBNodo {
	public int[] valores;
	public ArbolBNodo[] nodo;
	public static int numValores;
	public boolean tengoHijos = false;
	public int ocupados = 0;
	public ArbolBNodo padre;

	public ArbolBNodo() {
		nodo = new ArbolBNodo[ArbolBRaiz.grado * 2 + 3];
		valores = new int[ArbolBRaiz.grado * 2 + 1];
	}
}