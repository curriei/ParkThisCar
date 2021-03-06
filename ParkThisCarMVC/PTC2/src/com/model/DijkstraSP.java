package com.model;

public class DijkstraSP {
	private DirectedEdge[] edgeTo;
	private Double[] distTo;
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s){
		edgeTo= new DirectedEdge[G.V()];
		distTo= new Double[G.V()];
		pq= new IndexMinPQ<Double>(G.V());
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		pq.insert(s, 0.0);
		while(!pq.isEmpty())relax(G, pq.delMin());
	}
	
	private void relax(EdgeWeightedDigraph G, int v){
		for(DirectedEdge e : G.adj(v)){
			int w = e.to();
			if(distTo[w] > distTo[v] + e.weight()){
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else pq.insert(w, distTo[w]);
			}
		}
	}
	public double getDist(int w){
		return distTo[w];
	}
	public Double[] dists(){
		return distTo;
	}
}