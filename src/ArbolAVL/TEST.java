package ArbolAVL;

public class TEST {

	public static void main(String[] args) {

		ArbolAVL arbolAVL = new ArbolAVL();
		Integer elemento1 = new Integer("1");
		Integer elemento2 = new Integer("2");
		Integer elemento3 = new Integer("3");
		Integer elemento4 = new Integer("4");
		Integer elemento5 = new Integer("5");
		Integer elemento6 = new Integer("6");
		Integer elemento7 = new Integer("7");
		Integer elemento8 = new Integer("8");
//		Integer elemento9 = new Integer("9");

		arbolAVL.insert(elemento1);
		arbolAVL.insert(elemento2);
		arbolAVL.insert(elemento3);
		arbolAVL.insert(elemento4);
		arbolAVL.insert(elemento5);
		arbolAVL.insert(elemento6);
		arbolAVL.insert(elemento7);
		arbolAVL.insert(elemento8);
//		arbolAVL.insert(elemento9);

		arbolAVL.imprimirPorNiveles();

		int altura = arbolAVL.calcularAltura() + 1;

		System.out.println("n");
		System.out.println(altura + " altura del arbol");
		System.out.println("n");

		arbolAVL.imprimirPorAltura();
	}
}