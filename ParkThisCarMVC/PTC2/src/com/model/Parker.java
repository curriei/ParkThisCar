package com.model;
import java.io.IOException;
import java.util.*;


public class Parker{
	private ParkingSpot[] p;
	private EdgeWeightedDigraph g;
	
	public Parker(){
		ParkingSpot[] p = FileIO.importList("../../data/Street_parking_sign.txt");
		EdgeWeightedDigraph g = FileIO.importGraph("../../data/Street_Network_Database.txt");
		
	}
	
	public static ArrayList<String> mainFunc2(String adr, String day) throws Exception{
		String lat = GoogleAPI.LatAPI(adr);
		String lng = GoogleAPI.LngAPI(adr);
		
		Coordinate cnew = new Coordinate(Double.parseDouble(lat), Double.parseDouble(lng));
		int start = g.findClosestIntersection(cnew);
		
		DijkstraSP d = new DijkstraSP(g,start);
		
		Coordinate[] cs = new Coordinate[10];
		Double[] ds = new Double[10];
		for(int i = 0; i<10;i++){
			int vertex = g.findClosestIntersection(p[i].loc());
			cs[i] = g.coord(vertex);
			ds[i] = d.getDist(vertex);
		}
			
		QuickSort.sort(ds,p,0,9);
			
		int today = Integer.parseInt(day);
		int i = 0;
		ArrayList<String> out = new ArrayList<>();
		while(i<5 && i < p.length){
			if(p[i].freeToday(today)){
				/**String a3 = "Parking spot available at: " + p[i].loc().toString()+". Available from: " + p[i].sttme() + " to " + p[i].endtme() + "for (" + lat + ", " + lng + ")";
					//	" Available from: " + p[i].sttme() + " to " + p[i].endtme();
				//double a2 =  p[i].loc().getLat();
				//double b2 =  p[i].loc().getLongit();
				//String place = GOOGLEAPI.Location(a2, b2);**/
				String a3 ="Parking spot available at: " + p[i].loc().toString() + ".  Available from: " + p[i].sttme() + " to " + p[i].endtme() + ". ";
				out.add(a3);
				System.out.println(a3);
				i++;
			}
		}
	return out; 
	}
	/*
		public static ArrayList<String> mainFunc(String lat3, String lon3, String day) throws Exception{
			//line 6 runs with a small dataset, try it with the full dataset though to see if there are any issues
			ParkingSpot[] p = FileIO.importList("/Users/ibrahimmalik/2XB3/ParkThisCarMVC/ParkThisCar2/Street_parking_sign.txt");
			
			//line 9 there is an issue (looks to be with the bag class, have a look, let me know if there are any troubles...)
			EdgeWeightedDigraph g = FileIO.importGraph("/Users/ibrahimmalik/2XB3/ParkThisCarMVC/ParkThisCar2/Street_Network_Database.txt");
			
			
			//everything else below appears to be fine, there will be more once we have the code from me and ibrahim...
			Coordinate c = new Coordinate(Double.parseDouble(lat3),
					Double.parseDouble(lon3));
			int start = g.findClosestIntersection(c);
			
			DijkstraSP d = new DijkstraSP(g,start);
			
			Coordinate[] cs = new Coordinate[10];
			Double[] ds = new Double[10];
			for(int i = 0; i<10;i++){
				int vertex = g.findClosestIntersection(p[i].loc());
				cs[i] = g.coord(vertex);
				ds[i] = d.getDist(vertex);
			}
				
			QuickSort.sort(ds,p,0,9);
				
			int today = Integer.parseInt(day);
			int i = 0;
			ArrayList<String> out = new ArrayList<>();
			while(i<5 && i < p.length){
				if(p[i].freeToday(today)){
					//String a = "Parking spot available at: " + p[i].loc().toString()+
						//	" Available from: " + p[i].sttme() + " to " + p[i].endtme();
					double a2 =  p[i].loc().getLat();
					double b2 =  p[i].loc().getLongit();
					//String place = GOOGLEAPI.Location(a2, b2);
					String a3 ="Parking spot available at: " + ". Or if you prefer ultimate accuracy:  " + p[i].loc().toString() + ".  Available from: " + p[i].sttme() + " to " + p[i].endtme() + ". ";
							//" Available from: " + p[i].sttme() + " to " + p[i].endtme();
					//out.add(a);
					//System.out.println(a);
					//i++;
					out.add(a3);
					System.out.println(a3);
					i++;
					
				}
			}
		return out;	 
	}*/
}
		
	 

