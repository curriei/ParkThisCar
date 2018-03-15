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
        String regex = ",";
		
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
        ParkingSpot[] spots = new ParkingSpot[file.length-1];
        for(String[] line : file){
        	String txt = line[10];  //sign text
        	String cat = line[11];  //sign category ( PTIML is a good temp example)
        	char dir = line[14].charAt(0);   //sign facing direction
        	String cusTxt = line[22];  //custom txt on the sign
        	int stday = Integer.parseInt(line[23]);  //startday
        	int endday = Integer.parseInt(line[24]);  //endday
        	int sttme = Integer.parseInt(line[25]);  //starttime
        	int endtme = Integer.parseInt(line[26]);  //endtime
        	Double lat = Double.parseDouble(line[27].substring(1));  //latlong coordinates
        	Double longi = Double.parseDouble(line[28].
        			substring(0, line[28].length()-1));
        	ParkingSpot spot = new ParkingSpot(txt,cat,dir,
        			cusTxt,stday,endday,sttme,endtme,lat,longi);
        }
        
    }
        
	
	public static Graph importGraph(String fileName) throws IOException{
		String[][] file = importCSV(fileName); //reads csv file as a 2d array
		BSTbag bg = new BSTbag();
		LinkedList<Edge> lst = new LinkedList<>();
		int numNodes = 0;
		Stack<Edge> edges = new Stack<Edge>();
		
		for(int i = 1; i<file.length; i++){
			String[] line = file[i];
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
				
				String addTo = addressTo.toString()+stName;
				String addFrom = addressFrom.toString()+stName;
				
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
			}
		}
		Graph graph = new Graph(numNodes);
		for(int i = 0; i < numNodes; i++){
			graph.addEdge((Edge) edges.pop());
		}
		return graph;
	}
}
