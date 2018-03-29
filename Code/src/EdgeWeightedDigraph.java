import java.util.LinkedList;


public class EdgeWeightedDigraph {
	private final int V;
	private int E;
	private LinkedList<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (LinkedList<DirectedEdge>[]) new LinkedList[V];
		for (int v = 0; v < V; v++)
			adj[v] = new LinkedList<DirectedEdge>();
	}
	public int V() { return V; } 
	public int E() { return E; }
	public void addEdge(DirectedEdge e) {
		int v = e.from(), w = e.to();
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<DirectedEdge> adj(int v) { return adj[v]; }
	
}