//package com.GoogleTeams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;
import java.util.Collection;
import java.io.InputStreamReader;
import java.util.Hashtable;




public class PagerankTeams {
	
	ArrayList<ArrayList<Integer>> adj; // <-class variable/ field
	ArrayList<ArrayList<String>> namePref;
	ArrayList<Integer> prefCounter;
	private int thisOne;
	private int thisZero;
	private int [] teamArray;
	private static String fileName;
	double [] result; 
	int noPref = 0;
	private static int teamSize = 3;
	private static int v = 0;
	private static int t = 3;
	private static boolean v_one = false;
	private static boolean v_two = false;
	private static boolean v_three = false;
	private static boolean v_four = false;
  
	
	public static void main(String[] args) 
	{ 
	//Argument getter//
	
		if (args.length > 0) { 

            //System.out.println("The command line"+ 
            //                   " arguments are:"); 

            // iterating the args array and printing 
            // the command line arguments 
            for (int val = 0; val < args.length; val++) {

                if(args[val].equals("-v")){
                    if(Integer.valueOf(args[val + 1])> 0){
                        v_one = true;
                    }

                    if(Integer.valueOf(args[val + 1]) > 1){
						v_one = true;
                        v_two = true;
                    }

                    if(Integer.valueOf(args[val + 1]) > 2){
						v_one = true;
                        v_two = true;
                        v_three = true;
                    }

                    if(Integer.valueOf(args[val + 1]) > 3){
						v_one = true;
                        v_two = true;
                        v_three = true;
                        v_four = true;
                    }
					
					if(v_three)
						System.out.println("Verbosities: v1: "+ v_one+ " v2: " + v_two+ " v3: " + v_three+ " v4: " + v_four);
                }
			

                if(args[val].equals("-t")){
                    teamSize = Integer.valueOf(args[val+1]);
					if(teamSize < 2)
						teamSize = 2;
                }
	 
            }
        } else {
            System.out.println("No command line "+ 
                               "arguments found."); 
        }
	
		
	//Called Functions//
	
			PagerankTeams graph = new PagerankTeams();
			graph.adj = new ArrayList<ArrayList<Integer>> (); 
			
			boolean readable = graph.readFile(fileName);
			//boolean readable = graph.readFile("C:/Users/Matt/GoogleTeams/GoogleTeamFinder/Pref_Inputs6.csv");
			if(!readable)
				return;
			
			graph.listMaker();
			
			if(v_three){
				System.out.println("Before:");
				graph.printGraph(graph.adj); //Before graph has 1's
			}
			
				graph.addAdjacencies(graph.namePref);
				
			if(v_three){
				System.out.println("After:");
				graph.printGraph(graph.adj); //After graph has 1's
			}
			
			graph.pageRank_maker();
			
			String [] [] sortedNameArray = graph.arraySorter();
			
			graph.teamMaker(sortedNameArray);
			
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
      	if(v_two){
			System.out.println();
			System.out.print("Name:"+ name + "\n");
		}
		
		for(int rowIndex = 0; rowIndex < nameIndex.size(); rowIndex++){
			//System.out.print("D:"+ d + "\n \n");
			
			ArrayList<String> row = nameIndex.get(rowIndex);
			
			if(PagerankTeams.v_two)
				System.out.println(row.get(0)+"/// "+ name);
			
			if(row.get(0).equals(name)) {
				//System.out.print(row.get(0) + name);
				return rowIndex; //if name found, return name;
			}
		}
    	return -1;
    }

    public boolean readFile(String file) 
	{

        String line = "";
        String csvSplitBy = ",";
		
		namePref = new ArrayList();
		
		BufferedReader br;
			
		
		try{
			//System.out.println(file);
			
			if(file != (null)){
				FileReader inReader = new FileReader(file);
				br = new BufferedReader(inReader);	
			}
			else{
				InputStreamReader inFile = new InputStreamReader(System.in);
				br = new BufferedReader(inFile);
			}

          	while ((line = br.readLine()) != null){
            	ArrayList <String> adj_row = new ArrayList();
              	adj_row.addAll(Arrays.asList(line.split(csvSplitBy)));
                namePref.add(adj_row);
            }
			br.close();
		} catch (IOException e) {
            e.printStackTrace();
			return false;
        }
			
			if(namePref.size() < 1){
				System.out.println();
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!CSV Empty!!!!!!!!!!!!!!!!!!!!!!!!!!");
				return false;
			}
			
			if(namePref.get(0).get(0).equals("")){
				System.out.println();
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!CSV Empty!!!!!!!!!!!!!!!!!!!!!!!!!!");
				return false;
			}
			
			//if(namePref.get(0) == ""){
			//	System.out.println();
			//	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!CSV Empty!!!!!!!!!!!!!!!!!!!!!!!!!!");
			//	return false;
			//}
			
			if(teamSize > namePref.size()/2)
				teamSize = namePref.size()/2;
			
			
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
				  
					if(v_three)
						System.out.print(nameCatcher(csv_row.get(mColumn), namePref));
					
					ArrayList<Integer> rowTest = adj.get(mRow);
					if(v_three)
						System.out.println("rowTest worked.");
					int caughtName = nameCatcher(csv_row.get(mColumn), namePref);
					//rowTest.set(caughtName, 1); ---for tester
					adj.get(mRow).set(caughtName, 1);
					//int oneChecker = 1;
				  
					if(v_three)
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
			if(v_one)
				System.out.println("Matrix size: "+adj.size()+" by" +adj.size());
			
			for (int i = 0; i < adj.size(); i++) { 
				if(v_two)
					System.out.println("\nAdjacency list of vertex " + i);
				
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
			//PageRank pagerank = new PageRank(); //Linear pagerank
			PageRank_NonLinear pagerank = new PageRank_NonLinear();	 //Non Linear pagerank				
			pagerank.path = arrayListToArray(adj);
			double numNodes = namePref.size();
			result = pagerank.calc(numNodes);
			//checkResult = result[0];
			//return result;
			
			if(v_three){
				for(int c=0; c < result.length; c++)
					System.out.println("Pagerank Values: "+result[c]);
			}
		}
		
		public String[][] arraySorter(){
			double [] result_copy = new double [result.length];
			String [][] namePrefCopy = new String[namePref.size()][namePref.size()];
			double score; 
			
			for(int c=0; c < result.length; c++)
				result_copy[c] = result[c];
			
			
			//System.out.println(result.length);
			result = removeExtraZero(result);
			//System.out.println(result.length);

			
			if(v_three){
				System.out.println("Copy of result:");
			
				for(int c=0; c < result_copy.length; c++)
					System.out.println(result_copy[c]);
			}
			
			//System.out.println("Sorted:");
			
			for(int c=0; c < result.length; c++){
				//System.out.println(result[c]);				
				for(int d=0; d < namePref.size(); d++){
					String name = namePref.get(c).get(0);
					
					//System.out.println(name+"----");
					score = result_copy[c];
					//System.out.println(score);
					//System.out.println(score);
					
					//System.out.println(name);
					//if(Arrays.asList(namePref).indexOf(c)){
					//	namePrefCopy[d] = (namePref.get(d).get(0));
					//}
					
					int scoreIndex = indexer(result, score);
					
					if(v_four){
						System.out.println("Score Index:");
						System.out.println(scoreIndex + " " + c);
						System.out.println(namePrefCopy.length+ "//" + result.length);
					}
					
					
					namePrefCopy[c][0] = namePref.get(scoreIndex).get(0);
					
					String [] currentPref = namePref.get(scoreIndex).toArray(new String [0]);
					namePrefCopy[c] = currentPref;					
					
				}
				
			}
			//->for verbosity
			
			if(v_four){
				System.out.println("Sorted arrays of scores:");
				for(int c=0; c < namePrefCopy.length; c++){
					System.out.println("---");
					for(int d=0; d < namePrefCopy[c].length; d++)
						System.out.println("name:" + namePrefCopy[c][d]);
				}
				
				for(int c=0; c < namePrefCopy.length; c++){
					System.out.println(result[c]);
					System.out.println("copy:"+result_copy[c]);
					System.out.println("Name in original order:" + namePref.get(c).get(0));
					System.out.println();
				}
			}
			
			
			//result_copy = result;			
			//result = Arrays.sort(result);
			
			return namePrefCopy;
		
		}
		
		
		void teamMaker(String [][] sortedNameArray){
			int numTeams = namePref.size() / teamSize;
			
			ArrayList<String> team1 = new ArrayList<String>();
			ArrayList<String> alreadyPicked = new ArrayList<String>();
			ArrayList<Integer> teamScores = new ArrayList<Integer>(Collections.nCopies(namePref.size()+1, 0));
			this.prefCounter = new ArrayList<Integer>(Collections.nCopies(namePref.size(), 0));
			//Hashtable<String, int[]> personScores = new Hashtable<String, int[]>();
			String [][] teamHolder = new String [numTeams+1][teamSize]; 
			
			team1.add(sortedNameArray[0][0]);
			int currentTeam = 0;
			int currentTeamWeight = 0;
			
			
			for(int c=0; c < sortedNameArray.length; c++){
				
				//ArrayList<String> newTeam = new ArrayList<String>();
			
				for(int d=1; d < sortedNameArray[c].length; d++){

					String currentName = sortedNameArray[c][d];
					int prefChecker =  d;
				
					if(! alreadyPicked.contains(currentName)){
						//teamScores.set(prefChecker, teamScores.get(prefChecker)+1);
						//System.out.println(prefChecker + currentName);
						//newTeam.add(currentName);
						alreadyPicked.add(currentName);
						
						if(v_three){
						System.out.println("currentTeam, currentTeamweight, teamSize, teamHolder.length");
							System.out.println(currentTeam+"  "+currentTeamWeight+"  " +teamSize + "  "+teamHolder.length);
						}
						
						//System.out.println(currentTeam + currentTeamWeight + teamHolder.length);
						
						teamHolder[currentTeam][currentTeamWeight] = currentName;
						currentTeamWeight++;
						
						if(currentTeamWeight >= teamSize){
							currentTeam++;
							currentTeamWeight = 0;
						}
						
						//System.out.println(personScores.get(currentName)+ "  "+ currentName+ "    " +prefChecker);
						//personScores.get(currentName)[prefChecker] += 1;	

						
					}
					
					//System.out.println(alreadyPicked);
					//System.out.println("currentName:"+currentName);
					
					//for(int f =0; f < sortedNameArray.length; f++){
					//	for(int g=0; g < sortedNameArray[f].length; g++)
							//System.out.println(sortedNameArray[f][g]);
					
					//}
				}
			}
			
			//build teams, then go back and check scores
			
			
			ArrayList<ArrayList<Integer>> allScores = prefChecker(teamHolder);
			int runningCountTotal = 0;
			for(int l =0; l < allScores.size(); l++){
				runningCountTotal += teamMath(allScores.get(l));
			}
			
			
			//Output
			System.out.println("Pagerank Teams ( " + runningCountTotal +",  "+ printAns(prefCounter) + noPref + ")");
			
			for(int k = 0; k < teamHolder.length; k++){
				System.out.println();
				
				
				if(teamHolder[k][0] != null){
					System.out.print("Team "+ (k+1)+" ("+teamMath(allScores.get(k)) + "): ");
					for(int l = 0; l < teamHolder[k].length; l++){
						
						int indScore = allScores.get(k).get(l);
						if(teamHolder[k][l] != null)
							System.out.print(teamHolder[k][l]+ "("+indScore+") ");
					}
				}
			}
			
			
			
			//for(String name: personScores.keySet()){
			//	int [] nameArray = personScores.get(name);
				
			//	System.out.println(name);
				
			//	for(int z=0; z<nameArray.length; z++)
			//		System.out.print(nameArray[z]+" ");
				
			
			//}
			
			
			
			
			//for(int c =1; c < teamSize; c++){
				
			//	for(int d=0; d< ; d++)
			//	team1.add(sortedNameArray[c]);
			//	alreadyPicked.add(sortedNameArray[c]);
				
			//}
 			
			
		}
		
		
		ArrayList<ArrayList<Integer>> prefChecker(String [][] teamHolder){
			
		ArrayList<ArrayList<Integer>> allScores = new ArrayList<ArrayList<Integer>>(); 
		
		for(int team = 0; team<teamHolder.length; team++){
		
			ArrayList<Integer> memberScore = new ArrayList<Integer>();
			
			for(int member = 0; member<teamHolder[team].length; member++){
				
				int totScore = 0;
				
				for(int otherMember = 0; otherMember < teamHolder[team].length; otherMember++){
					
					String firstMember = teamHolder[team][member];
					String nextMember = teamHolder[team][otherMember];
					int foundName = findPref(firstMember, nextMember);
					
					//if(firstMember.equals("Calvin") && nextMember.equals("Blinkendorfer"))
					//	System.out.println("foundName"+foundName);
					
					if(foundName != 0){
						totScore += namePref.size()-foundName+1;
						prefCounter.set(foundName-1, prefCounter.get(foundName-1)+1);
						//System.out.println(prefCounter+ firstMember + nextMember);
					}
					
					//Verbosity
					//System.out.print(foundName+ "(" + firstMember + "," + nextMember + ")");
					
					
				}
			memberScore.add(totScore);
			
			//System.out.println(totScore + teamHolder[team][member]);
			if( totScore == 0 && teamHolder[team][member] != null)
				noPref++;
			
			}
			allScores.add(memberScore);
			//System.out.println(allScores);
		}
		
		return allScores;
		
		}
		
		
		int findPref(String name1, String name2){
		
			for(int c=0; c<namePref.size(); c++){
			
				if (namePref.get(c).get(0).equals(name1)){
					int foundName = namePref.get(c).indexOf(name2);
					
					if(foundName > -1)
						return foundName;
					
				}
			
			}
			
			//System.out.println(name1 + name2);
			
			return 0;
		
		}
		
		
		double [] removeExtraZero(double [] result){
		
			//print before and after of result and newResult
		
		
			Arrays.sort(result);
		
			if(result.length == namePref.size())
				return result;
			
			double [] newResult = new double [namePref.size()];
			
			for(int c=0; c < namePref.size(); c++){
				newResult[c] = result[c+result.length-namePref.size()]; 
			}
		
			return newResult;
		}
		
		boolean personExists(String name){
			
			for(int c=0; c< namePref.size(); c++){
				System.out.println(name + namePref.get(c).get(0));
				
				if(namePref.get(c).get(0).equals(name))
					return true;
					
			}
			
			return false;
		
		}
		
		
		int indexer(double[] checker, double setter){
		
			for(int c=0; c < checker.length; c++){
				if(checker[c] == setter)
					return c;
			}	
			return -1;
		}			
		
		
		int teamMath(int [] teamScores){
			
			int sum = 0;
		
			for(int c=0; c < teamScores.length; c++){
				//System.out.println("---"+teamScores[c]);
				sum ++;
			}
		
			return sum;
		}
		
		int teamMath(ArrayList<Integer> teamScores){
			
			int sum = 0;
		
			for(int c=0; c < teamScores.size(); c++){
				//System.out.println("---"+teamScores.get(c));
				sum += teamScores.get(c);
			}
		
			return sum;
		}
		
		
		String printAns (ArrayList<Integer> ans ){
			String value = "";
			
			for(int c=0; c < ans.size(); c++)
				value+= ans.get(c)+", ";
			
			return value;
			
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
		
		public int [] teamList(){
			return teamArray;
		}
}
