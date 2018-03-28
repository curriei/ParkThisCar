import java.net.*;
import java.io.*;
import java.lang.reflect.*;

public class second_source_for_get_CSV_Data {
	
	public static void main(String[] args) {
		
		    File Street_Parking_Data = new File("src/Street_Parking_Sign__arcgis_rest_services_SDOT_EXT_DSG_datasharing_MapServer_2_.csv");
			//File Street_Parking_Data = new File("src/dummy.csv");
			BufferedReader br = null;
			FileReader fr = null;
		
			try {
			
				fr = new FileReader(Street_Parking_Data);
				br = new BufferedReader(fr);
				File LONG_LAT = new File("src/LONG_LAT.csv");
				FileWriter fw = null;
				fw = new FileWriter(LONG_LAT);
				BufferedWriter bw = null;
				bw = new BufferedWriter(fw);

				String Street_Sign_Info_Line;

				while (( Street_Sign_Info_Line = br.readLine()) != null) {
					
			    
					String[] Street_Sign_Info_Line_2 = Street_Sign_Info_Line.split(",");
				
					int n = Array.getLength(Street_Sign_Info_Line_2);
					
					String street = "";
					
					for (int i = 0; i < n; i++){
						
						if (i == 4 || i == 5 || i == 6 || i == 8 || i == 9  || i == 11  || i == 13 || i == 14 || i == 22  || i == 23  || i == 24  || i == 25  || i == 26  || i == 27) {
							
							street = street+Street_Sign_Info_Line_2[i]+",";
							
						}
						
					}
					
					System.out.println(street);
					bw.write(street);
					bw.newLine();
					
				}
				
				bw.close();
			
				}catch (IOException e) {

					e.printStackTrace();

				}
		
		
		
		}


}
