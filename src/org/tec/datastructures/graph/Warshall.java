package org.tec.datastructures.graph;

public class Warshall {
	private int[][] warshall;
	private int n=0;

	public Warshall (int n) {		
		int dato=0;
		warshall=new int[n][n];
	}
	
	public void addConection (int i , int j) {
		warshall[i][j] = 1;
	}
	
	public void makeTran () {
		for (int k=0;k<=n-1;k++) {
			for (int i=0;i<=n-1;i++) {
				for (int j=0;j<=n-1;j++) {
					warshall[i][j]=funcionwar(i,j,k);
				}
			}
		}
	}
	
	public int[][] getWarshall () {
		return warshall;
	}
	
	private int funcionwar(int i, int j, int k) {
		if ((warshall[i][j]==1)||((warshall[i][k]==1)&&(warshall[k][j]==1)))
			return 1;
		else
			return 0;
	}
}
