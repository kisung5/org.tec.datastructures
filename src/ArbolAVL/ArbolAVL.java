package ArbolAVL;

class ArbolAVL {
	private static AVLNode root;

	public void insert(Comparable x) {
		root = insertar(x, root);
	}

	private AVLNode insertar(Comparable x, AVLNode t) {
		if (t == null) {
			t = new AVLNode(x, null, null);
		} else if (x.compareTo(t.dato) < 0) {
			t.izquierdo = insertar(x, t.izquierdo);
			if (height(t.izquierdo) - height(t.derecho) == 2) {
				if (x.compareTo(t.izquierdo.dato) < 0) {
					t = rotacionHijoIzquierdo(t); /* Caso 1 */
				} else {
					t = rotacionDobleHijoIzquierda(t); /* Caso 2 */
				}
			}
			} else if (x.compareTo(t.dato) > 0) {
				t.derecho = insertar(x, t.derecho);
				if (height(t.derecho) - height(t.izquierdo) == 2) {
					if (x.compareTo(t.derecho.dato) > 0) {
						t = rotacionHijoDerecho(t); /* Caso 4 */
					} else {
						t = rotacionDobleHijoDerecho(t); /* Caso 3 */
					}
				}
			}
		return null;			//// CONFIRMAR QUE SIRVA ASI, estaba sin cerrar aca
		
	}

	private static int max(int izquierdaHeight, int derechaHeight) {
		return izquierdaHeight > derechaHeight ? izquierdaHeight : derechaHeight;
	}

	private static AVLNode rotacionHijoIzquierdo(AVLNode t) {
		AVLNode aux2 = t.izquierdo;
		t.izquierdo = aux2.derecho;
		aux2.derecho = t;
		t.height = max(height(t.izquierdo), height(t.derecho)) + 1;
		aux2.height = max(height(aux2.izquierdo), t.height) + 1;
		return aux2;
	}

	private static AVLNode rotacionHijoDerecho(AVLNode t) {
		AVLNode aux2 = t.derecho;
		t.derecho = aux2.izquierdo;
		aux2.izquierdo = t;
		t.height = max(height(t.izquierdo), height(t.derecho)) + 1;
		aux2.height = max(height(aux2.derecho), t.height) + 1;
		return aux2;
	}

	private static AVLNode rotacionDobleHijoIzquierda(AVLNode aux) {
		aux.izquierdo = rotacionHijoDerecho(aux.izquierdo);
		return rotacionHijoIzquierdo(aux);
	}

	private static AVLNode rotacionDobleHijoDerecho(AVLNode aux) {
		aux.derecho = rotacionHijoIzquierdo(aux.derecho);
		return rotacionHijoDerecho(aux);
	}

	private static int height(AVLNode t) {
		return t == null ? -1 : t.height;
	}

	public void imprimir() {
		imprimir(root);
	}

	private void imprimir(AVLNode nodo) {
		if (nodo != null) {
			imprimir(nodo.derecho);
			System.out.println("[" + nodo.dato + "]");
			imprimir(nodo.izquierdo);
		}
	}

	public void imprimirPorAltura() {
		imprimirPorAltura(root);
	}

	private void imprimirPorAltura(AVLNode nodo) {
		if (nodo != null) {
			imprimirPorAltura(nodo.derecho);
			System.out.println(replicate(" ", height(root) - height(nodo)) + "[" + nodo.dato + "]");
			imprimirPorAltura(nodo.izquierdo);
		}
	}

	private static String replicate(String a, int cnt) {
		String x = new String("");
		for (int i = 0; i < cnt; i++) {
			x = x + a;
		}
		return x;
	}

	public int calcularAltura() {
		return calcularAltura(root);
	}

	private int calcularAltura(AVLNode actual) {
		if (actual == null) {
			return -1;
		} else {
			return 1 + Math.max(calcularAltura(actual.izquierdo), calcularAltura(actual.derecho));
		}
	}

	public void imprimirPorNiveles() {
		imprimirPorNiveles(root);
	}

	private void imprimirPorNiveles(AVLNode nodo) {
		int max = 0;
		int nivel = calcularAltura();
		
		for (; nivel >= 0; nivel--) {
		   max += Math.pow(2, nivel);
		}
		   max++; // Suma 1 para no utilizar la posicion 0 del array
		   
		   AVLNode cola[] = new AVLNode[max];
		   
		   // Carga en la pos 1 el nodo raiz
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
		   int cont = 0;  // contador para cada nivel
		   int cantidad = 1; // cantidad de nodos por nivel
		   int ultimaPosicion = 1; // ultimaPosicion del nodo en la cola de cada nivel
		   // Cuando i es = a 2^nivel hay cambio de nivel
		   // 2 ^ 0 = 1 que es el nodo raiz
		   
		   for (int i = 1; i < max; i++) {
			   if (i == Math.pow(2, nivel)) {
				   // Nodo raiz tiene nivel 1, por eso (nivel + 1)
				   System.out.print("n Nivel " + (nivel) + ": ");
				   nivel++; 
				   } 
			   if (cola[i] != null) {
				   System.out.print("[" + cola[i].dato + "]"); 
				   cont++; 
			   }
			   if (ultimaPosicion == i && cantidad == Math.pow(2, --nivel)) { 
				   
				   if (cantidad == 1) {
					   System.out.print(" Cantidad de nodos: " + cont + " (raiz)");
				   } else {
					   System.out.print(" Cantidad de nodos: " + cont);
				   }
				   cont = 0; 
				   cantidad *= 2;
				   ultimaPosicion += (int) Math.pow(2, ++nivel);
			   }
		   }
	}}
		
