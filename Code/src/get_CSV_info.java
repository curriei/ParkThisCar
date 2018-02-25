import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;

public class get_CSV_info {
	
	public static void main(String[] args) {
		
		File Annual_Parking_Study_Data = new File("src/Annual_Parking_Study_Data.csv");
		//You will probably need to change the pathname a little bit but it should work the same.
		
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(Annual_Parking_Study_Data);
			br = new BufferedReader(fr);

			String Parking_Lot_Info_Line;

			while (( Parking_Lot_Info_Line = br.readLine()) != null) {
			    
			    String regex = ",";
			    
			    char[] comma = regex.toCharArray();
			    for (char csv : comma) {
			    	
			    	Parking_Lot_Info_Line = Parking_Lot_Info_Line.replace(",,", ",");
			    	Parking_Lot_Info_Line = Parking_Lot_Info_Line.replace(""+csv, "       ");
			    	
			    }
			    
			    
				String[] Parking_Lot_Info_Line_2 = Parking_Lot_Info_Line.split("       ");
				
				System.out.println(Arrays.toString(Parking_Lot_Info_Line_2)); //This part is just to show that we get the information as line by line arrays.
				
//				int n = Array.getLength(Parking_Lot_Info_Line_2);
				
//				for (int i = 0; i < n; i++) {
					
//					if (i == 0 | i == 6 | i == 7 | i == 8 | i == 9 | i == 10) {
						
//						String Parking_Lot_Info_Line_3 = Parking_Lot_Info_Line_2[i];
						
//						System.out.println(Parking_Lot_Info_Line_3);
						
//					}
					
//				}
			}
			
			}catch (IOException e) {

				e.printStackTrace();

		}
		
		
		
	}

}
