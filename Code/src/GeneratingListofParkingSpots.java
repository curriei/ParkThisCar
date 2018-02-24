
public class GeneratingListofParkingSpots {
	
	public void SeparateListofLists(MasterList[]) {
		
		//Want to take the list of lists and split it according to the separate lists as in list of latitudes, longitudes,
		//times, availability days, and paid or not paid info
	
	
	int[] list1 = new int[200]; // Random number, essentially I want this list to be the list of parking places, i'm not sure what
			                 //the size of that list would be yet
	
	
	String[] arrayOfParkingSpotObjects = new String[list1.length]; //chose a string representation for this array because this is
	//the list of those objects and since the object itself consist of both numerical parameters and string parameters I went with this

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//TAKING THE LINKED LIST APPROACH HERE//
	
	// reference : https://stackoverflow.com/questions/1474954/working-with-a-list-of-lists-in-java
	// they were working with the exact same scenario "I'm trying to read a CSV file into a list of lists (of strings), 
	//pass it around for getting some data from a database, build a new list of lists of new data, then pass that list of
	//lists so it can be written to a new CSV file. I've looked all over, and I can't seem to find an example on how to do it.
	//I'd rather not use simple arrays since the files will vary in size and I won't know what to use for the dimensions of
	//the arrays. I have no issues dealing with the files. I'm just not sure how to deal with the list of lists. Most of the 
	//examples I've found will create multi-dimensional arrays or perform actions inside the loop that's reading the data from 
	//the file. I know I can do that, but I want to write object-oriented code. If you could provide some example code or point 
	//me to a reference, that would be great."
	//SO BASICALLY I feel that we can take a similar approach perhaps?
	
	// The basic goal here is to 
	//1) Create the correct number of linked list objects, either we create them prior elsewhere and create the # of objects
	//based on the given data set
	//2)Go through a for loop for each of the sublists within the MASTERlist and append say element index[2] - say this represents
	//the latitude for each of the objects within the list of parking spot objects, more so interlaced loops less so overlapping loops
	//or nested loops 
	
	//I'm currently working on both of those ideas but I felt like throwing this up here so that you guys can be aware of my
	//train of thought and feel free to add your input too - also working on Milestone 2 - will update with progress soon!
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
	ArrayList<String> singleList = new ArrayList<String>();
	singleList.add("hello");
	singleList.add("world");
	listOLists.add(singleList);

	ArrayList<String> anotherList = new ArrayList<String>();
	anotherList.add("this is another list");
	listOLists.add(anotherList);
	
	
	
	
	}
}
	
	//use the linked list utility already in java, use a linked list in 