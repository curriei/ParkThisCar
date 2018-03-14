
public class Edge implements Comparable<Edge>{
	private final int v;
	private final int w;
	private final double weight;
	
	public Edge(int v, int w, double weight){
		
	}
	
	public int getFrom(){
		return this.v;
	}
	public int getTo() {
		return this.w;
	}
	public double getWeight(){
		return this.weight;
	}
}
