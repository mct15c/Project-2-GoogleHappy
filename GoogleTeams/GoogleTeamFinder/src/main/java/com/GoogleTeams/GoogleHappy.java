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
	double [] result; 
  

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
			
			String [] sortedNameArray = graph.arraySorter();
			
			//teamMaker(sortedNameArray);
			
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
			PageRank pagerank = new PageRank(); //Linear pagerank
			//PageRank_NonLinear pagerank = new PageRank_NonLinear();	 //Non Linear pagerank				
			pagerank.path = arrayListToArray(adj);
			double numNodes = namePref.size();
			result = pagerank.calc(numNodes);
			
			
			//for(int c=0; c < result.length-1; c++)
				//System.out.println(result[c]);
		}
		
		public String[] arraySorter(){
			double [] result_copy = new double [result.length];
			String [] namePrefCopy = new String[namePref.size()];
			double score; 
			
			for(int c=0; c < result.length-1; c++)
				result_copy[c] = result[c];
			
			Arrays.sort(result);
			
			//System.out.println("Copy:");
			
			//for(int c=0; c < result_copy.length-1; c++)
			//	System.out.println(result_copy[c]);
			
			//System.out.println("Sorted:");
			
			for(int c=1; c < result.length; c++){
				//System.out.println(result[c]);
				
				for(int d=0; d < namePref.size(); d++){
					String name = namePref.get(c-1).get(0);
					score = result_copy[c-1];
					//System.out.println(score);
					
					//System.out.println(name);
					//if(Arrays.asList(namePref).indexOf(c)){
					//	namePrefCopy[d] = (namePref.get(d).get(0));
					//}
					
					int scoreIndex = indexer(result, score);
					//System.out.println(scoreIndex + " " + c);
					
					
					//System.out.println(namePrefCopy.length+ " //" + result.length);
					
					
					namePrefCopy[c-1] = namePref.get(scoreIndex-1).get(0);
					
					
					
				}
				
			}
			//->for verbosity
			/*
			for(int c=0; c < namePrefCopy.length; c++)
				System.out.println(namePrefCopy[c]);
			
			for(int c=0; c < namePrefCopy.length; c++){
				System.out.println(result[c]);
				System.out.println("copy:"+result_copy[c]);
				System.out.println("Name in original order:" + namePref.get(c).get(0));
			}
			*/
			
			//result_copy = result;			
			//result = Arrays.sort(result);
			
			return namePrefCopy;
		
		}
		
		/*
		void teamMaker(){
			ArrayList<String> team1 = new ArrayList<String>();
			
			
			for(int c =0; c < 
 			
			
			
			
		}
		*/
		
		
		
		int indexer(double[] checker, double setter){
		
			for(int c=0; c < checker.length; c++){
				if(checker[c] == setter)
					return c;
			}	
			return -1;
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
