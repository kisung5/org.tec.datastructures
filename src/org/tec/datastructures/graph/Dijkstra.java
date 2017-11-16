package org.tec.datastructures.graph;

import java.util.ArrayList;

public class Dijkstra {
	  int[][] graph;
	  int nNodes;
	  ArrayList conj_S = new ArrayList();
	  ArrayList conjComp_S = new ArrayList();
	  ArrayList caminos = new ArrayList();

	  public Dijkstra(int numNodos){
		  graph = new int[numNodos][numNodos];
		  int aux=0;
		  nNodes=numNodos;
	  }
	  
	  public void setBonds(ArrayList c1, ArrayList c2, ArrayList caminos) {
		  conj_S = c1;
		  conjComp_S = c2;
		  this.caminos = caminos;
	  }
	  
	  public void setGraph (int[][] graph) {
		  this.graph = graph;
	  }

	  private void resolve(int origen){
		  int nod;
		  int minimo;
		  int aux;
		  int nodCambio=0;
		  int intento;
		  String tmp2;
		  for(int i=0;i<nNodes;i++){
			  if(i!=origen) {
				  conjComp_S.add(""+i);
			  } else {
				  conj_S.add(""+i);
				  caminos.add("");
			  }
			  for(int k=0;k<nNodes;k++){
				  minimo=-1;
				  for(int j=0;j<conjComp_S.size();j++){
					  nod=Integer.valueOf((String)(conjComp_S.get(j))).intValue();
					  aux=algorithm(nod);
					  if(minimo==-1 || (aux<minimo && aux!=-1)){
						  minimo=aux;
						  nodCambio=j;
					  }
				  }
				  if(minimo!=-1){
					  conj_S.add(""+(String)(conjComp_S.get(nodCambio)));
					  conjComp_S.remove(nodCambio);
				  }
			  }
		  }
	  }

	  private int algorithm(int dest){
		  int min=-1;
		  int nod=0;
		  int nodOrig=-1;
		  int aux;
		  for(int i=0;i<conj_S.size();i++){
			  nod=Integer.valueOf((String)(conj_S.get(i))).intValue();
			  if(graph[nod][nod]!=-1 && graph[nod][dest]!=-1)
				  aux=graph[nod][nod]+graph[nod][dest];
			  else
				  aux=-1;
			  if((aux<min && aux!=-1)||min==-1){
				  min=aux;
				  nodOrig=nod;
			  }
		  }
		  if(min!=-1){
			  graph[dest][dest]=min;
			  caminos.set(dest,""+(char)(nodOrig+65));
		  }
		  return min;
	  }
	}
