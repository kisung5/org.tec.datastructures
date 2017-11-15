package org.tec.datastructures.tree;

public class ArbolAVL {
	private ArbolAVLNodo root;

	public void insert(Comparable x) {
		root = insert(x, root);
	}

	
	private ArbolAVLNodo insert(Comparable x, ArbolAVLNodo t) {
		if (t == null)
			t = new ArbolAVLNodo(x, null, null);
		else if (x.compareTo(t.dato) < 0) {
			t.izquierdo = insert(x, t.izquierdo);
			if (height(t.izquierdo) - height(t.derecho) == 2)
				if (x.compareTo(t.izquierdo.dato) < 0)
					t = rotateWithLeftChild(t); //Caso 1
				else
					t = doubleWithLeftChild(t); // Caso 2
		} else if (x.compareTo(t.dato) > 0) {
			t.derecho = insert(x, t.derecho);
			if (height(t.derecho) - height(t.izquierdo) == 2)
				if (x.compareTo(t.derecho.dato) > 0)
					t = rotateWithRightChild(t); // Caso 4
				else
					t = doubleWithRightChild(t); // Caso 3
		} else
			;
		t.height = max(height(t.izquierdo), height(t.derecho)) + 1;
		return t;
	}

	private static int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	private static ArbolAVLNodo rotateWithLeftChild(ArbolAVLNodo k2) {
		ArbolAVLNodo k1 = k2.izquierdo;
		k2.izquierdo = k1.derecho;
		k1.derecho = k2;
		k2.height = max(height(k2.izquierdo), height(k2.derecho)) + 1;
		k1.height = max(height(k1.izquierdo), k2.height) + 1;
		return k1;
	}

	private static ArbolAVLNodo rotateWithRightChild(ArbolAVLNodo k1) {
		ArbolAVLNodo k2 = k1.derecho;
		k1.derecho = k2.izquierdo;
		k2.izquierdo = k1;
		k1.height = max(height(k1.izquierdo), height(k1.derecho)) + 1;
		k2.height = max(height(k2.derecho), k1.height) + 1;
		return k2;
	}

	private static ArbolAVLNodo doubleWithLeftChild(ArbolAVLNodo k3) {
		k3.izquierdo = rotateWithRightChild(k3.izquierdo);
		return rotateWithLeftChild(k3);
	}

	private static ArbolAVLNodo doubleWithRightChild(ArbolAVLNodo k1) {
		k1.derecho = rotateWithLeftChild(k1.derecho);
		return rotateWithRightChild(k1);
	}

	private static int height(ArbolAVLNodo t) {
		return t == null ? -1 : t.height;
	}

	public void imprimir() {
		imprimir(root);
	}

	private void imprimir(ArbolAVLNodo nodo) {
		if (nodo != null) {
			imprimir(nodo.derecho);
			System.out.println("[" + nodo.dato + "]");
			imprimir(nodo.izquierdo);
		}
	}

	public void imprimirXaltura() {
		imprimirXaltura(root);
	}

	private void imprimirXaltura(ArbolAVLNodo nodo) {
		if (nodo != null) {
			imprimirXaltura(nodo.derecho);
			System.out.println(replicate(" ", height(root) - height(nodo)) + "[" + nodo.dato + "]");
			imprimirXaltura(nodo.izquierdo);
		}
	}

	private static String replicate(String a, int cnt) {
		String x = new String("");

		for (int i = 0; i < cnt; i++)
			x = x + a;
		return x;
	}

	public int calcularAltura() {
		return calcularAltura(root);
	}

	private int calcularAltura(ArbolAVLNodo actual) {
		if (actual == null)
			return -1;
		else
			return 1 + Math.max(calcularAltura(actual.izquierdo), calcularAltura(actual.derecho));
	}

	public void imprimirPorNiveles() {
		imprimirPorNiveles(root);
	}

	private void imprimirPorNiveles(ArbolAVLNodo nodo) {
		int max = 0;
		int nivel = calcularAltura();

		for (; nivel >= 0; nivel--)
			max += Math.pow(2, nivel);
		max++; 

		ArbolAVLNodo cola[] = new ArbolAVLNodo[max];

		cola[1] = nodo;
		int x = 1;
		
		for (int i = 2; i < max; i += 2, x++) {
			if (cola[x] == null) {
				cola[i] = null;
				cola[i + 1] = null;
			} else {
				cola[i] = cola[x].izquierdo;
				cola[i + 1] = cola[x].derecho;
			}
		}
		nivel = 0;
		int cont = 0; 
		int cantidad = 1;
		int ultimaPosicion = 1; 


		for (int i = 1; i < max; i++) {
			if (i == Math.pow(2, nivel)) {
				System.out.print("\n Nivel " + (nivel) + ": ");
				nivel++;
			}
			if (cola[i] != null) {
				System.out.print("[" + cola[i].dato + "]");
				cont++;
			}
			if (ultimaPosicion == i && cantidad == Math.pow(2, --nivel)) {
				if (cantidad == 1)
					System.out.print(" Cantidad de nodos: " + cont + " (raiz)");
				else
					System.out.print(" Cantidad de nodos: " + cont);
				cont = 0;
				cantidad *= 2;
				ultimaPosicion += (int) Math.pow(2, ++nivel);
			}
		}
	}
}