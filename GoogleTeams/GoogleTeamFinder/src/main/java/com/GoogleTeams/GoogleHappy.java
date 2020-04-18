import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

public class GoogleHappy {
	
	ArrayList<ArrayList<Integer>> adj; // <-class variable/ field
	ArrayList<ArrayList<String>> namePref;
	private int thisOne;
	private int thisZero;
  

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
			
			graph.pageRank_maker();
			
			//PageRank p = new PageRank();
			//p.path = arrayListToArray(graph.adj);
			//p.calc(graph.adj.size());
			
	}
	
	public void listMaker()
	{
		
		boolean allZeroes = true;
		for (int i = 0; i < namePref.size(); i++) {
				
				ArrayList<Integer> zeroList = new ArrayList<Integer>();
				
				
				for(int c=0; c < namePref.size(); c++){ 
					zeroList.add(0);
				}
				
				adj.add(zeroList);
							
				System.out.println(" ");
		}
	
	}
	
	//For tests
	/*
	public List getList(){
		return zeroList;
	}
	*/
  
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
				int zeroChecker = 0;

				for(int mColumn = 1; mColumn < csv_row.size(); mColumn++){
				  
					//System.out.print(nameCatcher(csv_row.get(mColumn), namePref));
					
					adj.get(mRow).set(nameCatcher(csv_row.get(mColumn), namePref), 1);
					//int oneChecker = 1;
				  
					//System.out.print(adj.get(mRow).get(mColumn));

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
		
		public int[][] arrayListToArray(ArrayList<ArrayList<Integer>> adj){
			int[][] newArray = new int[adj.size()][adj.size()];
			
			for(int c = 0; c < adj.size(); c++){
				
				
				for(int d=0; d < adj.size(); d++){
					newArray[c][d] = adj.get(c).get(d);
				
				}
				
			}
			
			return newArray;
		}
		
		
		public void pageRank_maker(){
			PageRank pagerank = new PageRank(); 
			pagerank.path = arrayListToArray(adj);
			double numNodes = namePref.size();
			pagerank.calc(numNodes-1);
		}
		
		
		public int getRowSize(){
			//System.out.println("Other rowSize:" +rowSize);
			return adj.get(0).size();
		}
		
		public int getColumnSize(){
			return adj.size();
		}
		
		public int zeroChecker(){
			return thisZero;
		}
		
		public int oneChecker(){
			return thisOne;
		}
} 
