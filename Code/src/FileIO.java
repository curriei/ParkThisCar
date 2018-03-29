import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class FileIO {
        
        
	public static String[][] importCSV(String fileName) throws IOException{
        LinkedList<String[]> linkedList = new LinkedList<>();
        String[][] result;
            
		File Annual_Parking_Study_Data = new File(fileName);		
		
		BufferedReader br;
		FileReader fr;
        String regex = "\t";
		
		fr = new FileReader(Annual_Parking_Study_Data);
		br = new BufferedReader(fr);

		String Parking_Lot_Info_Line;
                        
        br.readLine(); //deals with the title row
		while (( Parking_Lot_Info_Line = br.readLine()) != null) {
			String[] line = Parking_Lot_Info_Line.split(regex);
            linkedList.add(line);  
        }			
        result = linkedList.toArray(new String[linkedList.size()][]);
		
        return result;		
	}
      
	//temporarily commented out while we figure out the stuff for working copy
    public static ParkingSpot[] importList(String fileName) throws IOException{
        String[][] file = importCSV(fileName);
        ParkingSpot[] spots = new ParkingSpot[file.length];
        int i = 0;
        for(String[] line : file){
        	String txt = line[10];  //sign text
        	String cat = line[11];  //sign category ( PTIML is a good temp example)
        	char dir = line[12].charAt(0);   //sign facing direction
        	String cusTxt = line[19];  //custom txt on the sign
        	int stday = (line[20].equals("") ? 1 : Integer.parseInt(line[20]));  //startday
        	int endday = (line[21].equals("") ? 7 : Integer.parseInt(line[21]));  //endday
        	int sttme = (line[22].equals("") ? 0 : Integer.parseInt(line[22]));  //starttime
        	int endtme = line[23].equals("") ? 2359 : Integer.parseInt(line[23]);  //endtime
        	String[] latLong = line[24].split(",");
        	Double lat = Double.parseDouble(latLong[0].substring(2,latLong[0].length()));  //latlong coordinates
        	Double longi = Double.parseDouble(latLong[1].substring(0, latLong[1].length()-2));
        	Coordinate coord = new Coordinate(lat,longi); 
        	ParkingSpot spot = new ParkingSpot(txt,cat,cusTxt,
        			dir,stday,endday,sttme,endtme,coord);
        	spots[i] = spot;
        	i++;
        }
        return spots;
        
    }
        
	
	public static Graph importGraph(String fileName) throws IOException{
		String[][] file = importCSV(fileName); //reads csv file as a 2d array
		BSTbag bg = new BSTbag();
		LinkedList<Edge> lst = new LinkedList<>();
		int numNodes = 0;
		Stack<Edge> edges = new Stack<Edge>();
		for(int i = 1; i<file.length; i++){
			String[] line = file[i];
			for(String item :line)
				System.out.print(item+ "; ");
			System.out.println();
			int streetType = Integer.parseInt(line[6]);
			if(streetType < 9){
				int from = Integer.parseInt(line[0]);  //from intersection
				int to = Integer.parseInt(line[1]);  //to intersection
				int speed = streetType == 4 ? 5280 : 3080;  //matches speed to ft/min
				String stName = line[24];  //street name
				Double stWeight = Double.parseDouble(line[36])/speed; //weight mesured in time
	
				//all of the below is literally JUST to get the address range
				Double fromAddress1 = Double.parseDouble(line[16]); 
				Double toAddress1 = Double.parseDouble(line[17]);
				Double fromAddress2 = Double.parseDouble(line[18]);
				Double toAddress2 = Double.parseDouble(line[19]);
				
				Double minAddressFrom = Math.min(fromAddress1, fromAddress2);
				Double maxAddressFrom = Math.max(fromAddress1, fromAddress2);
				
				Double addressTo = Math.max(toAddress1, toAddress2);
				Double addressFrom = minAddressFrom == 0 ? maxAddressFrom : minAddressFrom;
				
				String addTo = addressTo.toString()+" "+stName;
				String addFrom = addressFrom.toString()+" "+stName;
				
				int toNode, fromNode;
				if(!bg.contains(addTo)){
					bg.add(addTo,numNodes);
					toNode = numNodes++;
				}
				else toNode = (int) bg.get(addTo);
				if(!bg.contains(addFrom)){
					bg.add(addFrom, numNodes);
					fromNode = numNodes++;
				}
				else fromNode = (int) bg.get(addFrom);
				Edge edge = new Edge(toNode, fromNode,stWeight);
				edges.push(edge);
				System.out.println("we made one");
			}
		}
		Graph graph = new Graph(numNodes);
		while(!edges.isEmpty()){
			graph.addEdge((Edge) edges.pop());
		}
		return graph;
	}
}
