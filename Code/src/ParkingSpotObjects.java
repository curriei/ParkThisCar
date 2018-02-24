
public class ParkingSpotObjects {
	
	private double a; //a represents the latitude
	private double b; //b represents the longitude
	private double c;//c represents if it is paid or not, 1.0 for paid, 2.0 for not paid	
	private String d; //String representation of available times
	private String e; // String representation of available days 
	
	public ParkingSpotObjects(double a, double b, double c, String d, String e) {
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
	}
	
	double a() {
		return this.a;
	}
	double b() {
		return this.b;
	}
	double c() {
		return this.c;
	}
	String d() {
		return this.d;
	}
	String e() {
		return this.e;
	}

}
