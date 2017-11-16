package org.tec.datastructures.graph;

public class MatrixGraph {
	private int n;
	private int[][] matrix;

	public MatrixGraph(int n) {
		this.n = n;
		matrix = new int[this.n][this.n];
		for(int i=0; i< n; i++){
			for(int j=0; j< n; j++){
				matrix[i][j] = 0;
			}            
		}
	}
	
	public int[][] getMatrix() {
		return matrix;
	}

	public void add(int i, int j) {
		if (i > n || j > n) {
			return;
		} else {
			matrix[i][j] += 1;
		}
	}

	public void remove(int i, int j){
		if(matrix[i][j]>0)
			matrix[i][j] -= 1;
	}

	public void print(){
		for(int i=0; i< n; i++){
			for(int j=0; j< n; j++){
				System.out.print( matrix[i][j] + "  " );        
			}
			System.out.println();
		}  
	}
}
