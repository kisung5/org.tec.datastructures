package org.tec.datastructures.graph;

public class Floyd {

	private int[][] floyd;
	private int n;
	
	public Floyd (int n) {
		floyd=new int[n][n];
		this.n = n;
	}
	
	public void addConection (int i , int j) {
		floyd[i][j] = 1;
	}

	public void getOrdered () {
		for (int k=0;k<=n-1;k++) {
			for (int i=0;i<=n-1;i++) {
				for (int j=0;j<=n-1;j++) {
					if ((floyd[i][k]!=-1)&&(floyd[k][j]!=-1)) {
						floyd[i][j]=funcionfloyd(floyd[i][j],floyd[i][k]+floyd[k][j]);
					}
				}
			}
		}
	}
	
	public int[][] getFloyd() {
		return floyd;
	}

	private int funcionfloyd(int A, int B) {
		if ((A==-1)&&(B==-1)) {
			return -1;
		} else if (A==-1) {
			return B;
		} else if (B==-1) {
			return A;
		} else if (A>B) {
			return B;
		} else { 
			return A;
		}
	}      
}

