import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;

public class get_CSV_info {
	
	public static void main(String[] args) 
	{
		
		File Annual_Parking_Study_Data = new File("src/Annual_Parking_Study_Data.csv");

		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(Annual_Parking_Study_Data);
			br = new BufferedReader(fr);
			File STREET_PARKING = new File("src/STREET_PARKING.csv");
			FileWriter fw = null;
			fw = new FileWriter(STREET_PARKING);
			BufferedWriter bw = null;
			bw = new BufferedWriter(fw);

			String Parking_Lot_Info_Line;
		
			while (( Parking_Lot_Info_Line = br.readLine()) != null) {
			    
			    String regex = ",";
			    
			    char[] comma = regex.toCharArray();
			    for (char csv : comma) {
			    	
			    	Parking_Lot_Info_Line = Parking_Lot_Info_Line.replace(",,", ",");
			    	Parking_Lot_Info_Line = Parking_Lot_Info_Line.replace(""+csv, "       ");
			    }
			    
			    
				String[] Parking_Lot_Info_Line_2 = Parking_Lot_Info_Line.split("       ");
				
				int n = Array.getLength(Parking_Lot_Info_Line_2);
				String str = "";
				for (int i = 0; i < n; i++){
					
					if (i == 0 || i == 6 || i == 8 || i == 9 || i == 10) {
						
						str = str+Parking_Lot_Info_Line_2[i]+",";
						
					}
					
				}
				
				System.out.println(str);
				bw.write(str);
				bw.newLine();
				
			}
			
			bw.close();
			
		}catch (IOException e) {

			e.printStackTrace();
       
		}
		
	}
	
}