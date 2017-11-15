package org.tec.datastructures.list;

public class ArbolBinarioNodo {

	/* Declaraciones de variables */
	private int valor;

	private ArbolBinarioNodo padre;
	private ArbolBinarioNodo hojaIzquierda;
	private ArbolBinarioNodo hojaDerecha;

	/* Constructor */
	public ArbolBinarioNodo(int valor) {
		this.valor = valor;
	}

	/* Setters y Getters */
	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public ArbolBinarioNodo getPadre() {
		return padre;
	}

	public void setPadre(ArbolBinarioNodo padre) {
		this.padre = padre;
	}

	public ArbolBinarioNodo getHojaIzquierda() {
		return hojaIzquierda;
	}

	public void setHojaIzquierda(ArbolBinarioNodo hojaIzquierda) {
		this.hojaIzquierda = hojaIzquierda;
	}

	public ArbolBinarioNodo getHojaDerecha() {
		return hojaDerecha;
	}

	public void setHojaDerecha(ArbolBinarioNodo hojaDerecha) {
		this.hojaDerecha = hojaDerecha;
	}

}