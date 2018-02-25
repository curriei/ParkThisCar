import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class second_source_for_get_CSV_Data {
	
	//This code is similar to the last one minus some tweaking.
	public static void main(String[] args) {
		
		File Street_Parking_Data = new File("src/Street_Parking_Sign__arcgis_rest_services_SDOT_EXT_DSG_datasharing_MapServer_2_.csv");
			//Again you will probably need to change the pathname a little bit but it should work the same.
		
		
			BufferedReader br = null;
			FileReader fr = null;
		
			try {
			
				fr = new FileReader(Street_Parking_Data);
				br = new BufferedReader(fr);

				String Street_Sign_Info_Line;

				while (( Street_Sign_Info_Line = br.readLine()) != null) {
			    
			    
					String[] Street_Sign_Info_Line_2 = Street_Sign_Info_Line.split(",");
				
					System.out.println(Arrays.toString(Street_Sign_Info_Line_2)); //This part is just to show that we get the information as line by line arrays.

// Haven't edited this part of the code because I haven't checked the useful iterations but its still there till we figure out the linking part.

//Note: There is alot of data here and I couldn't even run it fully because I had to go somewhere so another thing to keep in mind. 					
					
//					int n = Array.getLength(Parking_Lot_Info_Line_2);
				
//					for (int i = 0; i < n; i++) {
					
//						if (i == 0 | i == 6 | i == 7 | i == 8 | i == 9 | i == 10) {
						
//							String Parking_Lot_Info_Line_3 = Parking_Lot_Info_Line_2[i];
						
//						}
					
//					}
				}
			
				}catch (IOException e) {

					e.printStackTrace();

				}
		
		
		
		}


}
