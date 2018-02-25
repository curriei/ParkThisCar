import java.util.LinkedList;

public class FillParkingSpotData {
	
	String InfoArray[] = {"...", ".....", "....."}; // This essentially being the Array of strings from Kanak's code, it has to 
	//be linked here into this 
	
	int arrayLength = InfoArray.length;
	
	public class ParkingSpotObject { //This is the version we would use if Kanak would be able to do her other implementation approach
		
			
		private String a; //a represents the latitude
		private String b; //b represents the longitude
		private String c;//c represents if it is paid or not, 1.0 for paid, 2.0 for not paid	
		private String d; //String representation of available times
		private String e; // String representation of available days 
			
		public ParkingSpotObject(String a, String b, String c, String d, String e) {
				
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
		}
	}
	
	
	public class ParkingSpotObject2 { // This is the version we are using with Kanak's working implementation
		
		private String a1;
		
		public ParkingSpotObject2(String a) {
			this.a1 = a1;
		}
		
	}
	
	public static LinkedList<ParkingSpotObject2> main(String args[]) {
		LinkedList<ParkingSpotObject2> ListObjs = new LinkedList<ParkingSpotObject2>();
		
		for (int i = 0; i < arrayLength; i++) {
			ListObjs.add(new ParkingSpotObject2(InfoArray[i]));
			}
		return ListObjs; 
}
}