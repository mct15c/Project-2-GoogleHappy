import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

public class GoogleHappy {
	
	ArrayList<ArrayList<Integer>> adj; // <-class variable/ field
	ArrayList<ArrayList<String>> namePref;
  

	public static void main(String[] args) 
	{ 
			GoogleHappy graph = new GoogleHappy();
			graph.adj = new ArrayList<ArrayList<Integer>> (); 
			// Creating a graph with 5 vertices 
			// Current length = 9, find out how to read it in. 9 is a placeholder
			
			graph.readFile("C:/Users/Matt/GoogleTeams/GoogleTeamFinder/Pref_Inputs.csv");
			
			graph.listMaker();
			
			System.out.println("Before:");
			graph.printGraph(graph.adj); //Before graph has 1's
			graph.addAdjacencies(graph.namePref);
	  
			// Adding edges one by one 
			  			
			graph.readFile("C:/Users/Matt/GoogleTeams/GoogleTeamFinder/Pref_Inputs.csv");
			
			System.out.println("After:");
			graph.printGraph(graph.adj); //After graph has 1's
	}
	
	public void listMaker()
	{
		for (int i = 0; i < namePref.size(); i++) {
				
				ArrayList<Integer> zeroList = new ArrayList<Integer>();
				
				
				for(int c=0; c < namePref.size(); c++){
					zeroList.add(0);
				}
				
				adj.add(zeroList);
							
				System.out.println(" ");
				
				
		}
	}
  
  	public Integer nameCatcher(String name, ArrayList<ArrayList<String>> nameIndex)
	{
      	
		//System.out.print("Name:"+ name + "\n");
		
		for(int rowIndex = 0; rowIndex < nameIndex.size(); rowIndex++){
			//System.out.print("D:"+ d + "\n \n");
			
			ArrayList<String> row = nameIndex.get(rowIndex);
			if(row.get(0).equals(name)) {
				//System.out.print(row.get(0) + name);
				return rowIndex; //if name found, return name;
			}
		}
    	return -1;
    }

    public boolean readFile(String file) 
	{

        String csvFile = file;
        String line = "";
        String csvSplitBy = ",";
		
		namePref = new ArrayList();
        
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

          	while ((line = br.readLine()) != null){
            	ArrayList <String> adj_row = new ArrayList();
              	adj_row.addAll(Arrays.asList(line.split(csvSplitBy)));
                namePref.add(adj_row);
            }
			
		} catch (IOException e) {
            e.printStackTrace();
			return false;
        }			
			
			return true;

    } 
	
	
	void addAdjacencies(ArrayList<ArrayList<String>> namePref)
	{
	
		//System.out.print(namePref.get(0));
			int size = namePref.size();
          
          	//ArrayList <String> nameIndex = new ArrayList();
          
            for(int mRow = 0; mRow < size; mRow++) {  ///// while we are not done with the file, keep looping through each row in the file
				
				ArrayList<String> csv_row = namePref.get(mRow);

				for(int mColumn = 1; mColumn < csv_row.size(); mColumn++){
				  // Suzie,Ivanka,Donald
				  
				  // current person -> Ivanka
				  // we know the current Adj Matrix is matrix
				  // we know Suzie wants Ivanka
				  // where is Suzie's row?
				  // we know the location (Suzie, Ivanka) in the matrix should be 1
				  
					System.out.print(nameCatcher(csv_row.get(mColumn), namePref));
					
					adj.get(mRow).set(nameCatcher(csv_row.get(mColumn), namePref), 1);
				  
					System.out.print(adj.get(mRow).get(mColumn));

				}
				  
				  
				System.out.print("\n");
			}
	
	}
		  
		// A utility function to add an edge in an 
		// undirected graph 
		
		
		void addEdge(ArrayList<ArrayList<Integer> > adj, 
							int u, int v) 
		{ 
			adj.get(u).add(v); 
			adj.get(v).add(u); 
		} 
	  
		// A utility function to print the adjacency list 
		// representation of graph 
		void printGraph(ArrayList<ArrayList<Integer> > adj) 
		{ 
			//System.out.print(adj.size());
			
			for (int i = 0; i < adj.size(); i++) { 
				//System.out.println("\nAdjacency list of vertex" + i);
				
				for (int j = 0; j < adj.get(i).size(); j++) { 
					System.out.print(" -> "+adj.get(i).get(j)); 
				} 
				
				System.out.println(); 
			} 
		} 
} 

/*

Calvin -> 0
Bubba -> 1
Blinkendorfer -> 2
...

adj.get(Bubba).get(Calvin)

			Calvin		Bubba		Blink		Suzie		Snoopie		Donald		Billy		Ivanka		Mitch
Calvin         0          0           1
Bubba          1          0           0
Blink          0          1           0
Suzie		   0          0           0          0           0          0           0          0           0
Snoopie		   0          0           0          0           0          0           0          0           0
Donald         0          0           0          0           0          0           0          0           0
Billy          0          0           0          0           0          0           0          0           0
Ivanka		   0		  0           0          1           0          1           1          0           0


*/
/*
Calvin,Bubba,Blinkendorfer,Suzie
Bubba,Snoopie,Donald
Blinkendorfer,Bubba,Billy,Ivanka
Suzie,Ivanka,Donald
Donald,Bubba,Ivanka,Mitch
Mitch,Snoopie,Bubba,Suzie,Ivanka,Donald
Snoopie,Bubba
Billy,Donald,Blinkendorfer
Ivanka,Donald,Billy,Suzie

9  Bob Jim  
Bob 0   1   1   1 0 0 0 0 0
Jim 0   0   0   0 1 0 1 0 0
0 1 0 0 0 0 0 1 1
0 0 0 0 1 0 0 0 1
0 1 0 0 0 1 0 0 1
0 1 0 1 1 0 1 0 1
0 1 0 0 0 0 0 0 0
0 0 1 0 1 0 0 0 0
0 0 0 1 1 0 0 1 0 */
