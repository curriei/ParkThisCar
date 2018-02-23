import java.util.LinkedList;


public class FileIO {

	
	// needs to know which kind of return importCSV gives
	public static Graph importGraph(String fileName){
		Graph graph = new Graph()
		String[][] file = importCSV(fileName); //reads csv file as a 2d array
		
		for(int i = 1; i<file.length; i++){
			String[] line = file[i];
			int streetType = Integer.parseInt(line[6]);
			if(streetType < 9){
				int from = Integer.parseInt(line[0]);  //from intersection
				int to = Integer.parseInt(line[1]);  //to intersection
				int speed = streetType == 4 ? 5280 : 3080;  //matches speed to ft/min
				String stName = line[24];  //streetname
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
				
				//adds the graph edge
				graph.add(from, to, stName, addressTo, addressFrom, stWeight);
			}
		}
		return graph;
	}
}
