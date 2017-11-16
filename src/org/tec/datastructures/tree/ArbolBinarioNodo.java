package org.tec.datastructures.tree;

public class ArbolBinarioNodo <T> {

	private T valor;

	private ArbolBinarioNodo<T> padre;
	private ArbolBinarioNodo<T> hojaIzquierda;
	private ArbolBinarioNodo<T> hojaDerecha;

	public ArbolBinarioNodo(T valor) {
		this.valor = valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public T getValor() {
		return valor;
	}

	public ArbolBinarioNodo<T> getPadre() {
		return padre;
	}

	public void setPadre(ArbolBinarioNodo<T> padre) {
		this.padre = padre;
	}

	public ArbolBinarioNodo<T> getHojaIzquierda() {
		return hojaIzquierda;
	}

	public void setHojaIzquierda(ArbolBinarioNodo<T> hojaIzquierda) {
		this.hojaIzquierda = hojaIzquierda;
	}

	public ArbolBinarioNodo<T> getHojaDerecha() {
		return hojaDerecha;
	}

	public void setHojaDerecha(ArbolBinarioNodo<T> hojaDerecha) {
		this.hojaDerecha = hojaDerecha;
	}

}