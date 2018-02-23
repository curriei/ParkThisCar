import java.util.LinkedList;


public class FileIO {

	
	// needs to know which kind of return importCSV gives
	public static Graph importGraph(String fileName){
		Graph graph = new Graph()
		String[][] file = importCSV(fileName);
		for(int i = 1; i<file.length; i++){
			String[] line = file[i];
			int streetType = Integer.parseInt(line[6]);
			if(streetType < 9){
				int from = Integer.parseInt(line[0]);
				int to = Integer.parseInt(line[1]);
				int speed = streetType == 4 ? 5280 : 3080;  //matches speed to ft/min
				String stName = line[24];
				Double stWeight = Double.parseDouble(line[36])/speed; //weight mesured in time
				int addresses //just need to add the stuff for the addresses and their range
				
				graph.add(from, to, stName, stWeight);
			}
		}
		return graph;
	}
}
