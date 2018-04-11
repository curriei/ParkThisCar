package com.model;

import java.util.LinkedList;
import java.util.TreeMap;


public class Graph {
	private final int V;
	private int E;
	private LinkedList<Integer>[] adj; 
	
	public Graph(int V)
	{
		this.V = V;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for(int v = 0; v<V; v++)
			adj[v] = new LinkedList<Integer>();
	}
	
	public int getV()
	{return this.V;}
	
	public int getE()
	{ return this.E; }
	
	public void addEdge(Edge e){		
		adj[e.getFrom()].addLast((e.getTo()));
		E++;
	}
	
	/*
	public Iterable<Integer> shortestPath(int v, int w){
		//idk yet
	}*/
	
	
	
}