package ArbolAVL;

public class Nodo {
	public Comparable<?> dato; // el dato del nodo
	public Nodo izquierdo; // hijo izquierdo
	public Nodo derecho; // hijo derecho
	public int height; // altura

	// Constructors
	public Nodo(Comparable<?> dato) { 
		this(dato, null, null); 
		}

	public Nodo(Comparable<?> dato, Nodo izq, Nodo der) { 
		this.dato = dato; 
		this.izquierdo = izq; 
		this.derecho = der; 
		height = 0; // altura predeterminada }} 
	}
}