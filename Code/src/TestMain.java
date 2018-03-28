
public class TestMain {
	public static void main(String[] args) throws Exception{
		
		//line 6 runs with a small dataset, try it with the full dataset though to see if there are any issues
		ParkingSpot[] p = FileIO.importList("Code/data/Street_parking_sign_t.txt");
		
		//line 9 there is an issue (looks to be with the bag class, have a look, let me know if there are any troubles...)
		//Graph g = FileIO.importGraph("Code/data/Street_Network_Database_t.txt");
		
		//everything else below appears to be fine, there will be more once we have the code from me and ibrahim...
		Coordinate c = new Coordinate(47.601224,-122.30782);
		
		
		for(ParkingSpot ps : p){
			ps.getDist(c);
		}
		QuickSort.sort(p,0,p.length-1);
		
		for(int i = 0; i<10; i++){
			System.out.println(p[i].toString() + ":: " + p[i].getDistToCoord());
		}
	
	}
}
