package org.tec.datastructures.tree;

import java.util.*;

public class ArbolBLista {
	public static ArrayList<Integer> ingresados;

	public ArbolBLista() {
		ingresados = new ArrayList<Integer>();
	}

	public boolean buscar(int valor) {
		boolean esta = false;
		for (int i = 0; i < ingresados.size() && !esta; i++) {
			if (ingresados.get(i) == valor) {
				esta = true;
			}
		}
		return esta;
	}
}