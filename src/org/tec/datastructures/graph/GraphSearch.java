package org.tec.datastructures.graph;

import java.util.ArrayList;

import org.tec.datastructures.list.Queue;

public class GraphSearch {

	public int[][] g;
	private boolean[] visitedAnchor;
	private boolean[] visitedDeep;
	
	public GraphSearch(int[][] g) {
		this.g = g;
		visitedAnchor = new boolean[g.length];
		visitedAnchor = new boolean[g.length];
	}
	
	public int[][] getG() {
		return g;
	}
	
	public void setG(int[][] g) {
		this.g = g;
	}

	public ArrayList<Integer> recorridoAnchura(int nodoI) {
		ArrayList<Integer> recorridos = new ArrayList<Integer>();
		visitedAnchor[nodoI] = true;
		Queue<Integer> cola = new Queue<Integer>();
		recorridos.add(nodoI);
		cola.enqueue(nodoI);

		while (!cola.isEmpty()) {
			int j = cola.dequeue().getValor();
			for (int i = 0; i < g.length; i++) {
				if (g[j][i] == 1 && !visitedAnchor[i]) {
					cola.enqueue(j);
					recorridos.add(i);
					visitedAnchor[i] = true;
				}
			}
		}
		return recorridos;
	}


	public ArrayList<Integer> recorridoProfunidad(int nodoI) {
		ArrayList<Integer> recorridos = new ArrayList<Integer>();
		visitedDeep[nodoI] = true;
		ArrayList<Integer> cola = new ArrayList<Integer>();
		recorridos.add(nodoI);
		cola.add(nodoI);

		while (!cola.isEmpty()) {
			int j = cola.remove(0);
			for (int i = 0; i < g.length; i++) {
				if (g[j][i] == 1 && !visitedDeep[i]) {
					cola.add(i);
					recorridos.addAll(recorridoProfunidad(i));
					visitedDeep[i] = true;
				}
			}
		}
		return recorridos;
	}
}
