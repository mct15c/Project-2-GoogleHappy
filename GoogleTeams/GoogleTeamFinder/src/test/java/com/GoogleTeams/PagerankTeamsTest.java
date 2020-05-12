//package com.GoogleTeams;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.runner.Description;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.FixMethodOrder;
import org.junit.rules.TestWatcher;
import org.junit.runners.MethodSorters;
import org.junit.*;
import java.util.ArrayList;



/**
 * Unit test for simple App.
 */
public class PagerankTeamsTest 
{
	
	private int rowNumber;
	private int columnNumber;
    PagerankTeams teams;
	
	@Rule 
	public TestRule watcher =
		new TestWatcher() {
			protected void starting(Description description){
				System.out.println("Starting test: " + description.getMethodName());
		}
	};
		
	@Before
	public void initialize(){
		teams = new PagerankTeams();
		teams.adj = new ArrayList<ArrayList<Integer>> (); 
		// Creating a graph with 5 vertices 
		// Current length = 9, find out how to read it in. 9 is a placeholder
		
		teams.readFile("C:/Users/Matt/GoogleTeams/GoogleTeamFinder/Pref_Inputs.csv");
		
		teams.listMaker();
	}
	
    @Test
    public void test1ReadFile()
    {
		boolean worked = teams.readFile("Pref_Inputs.csv");
		assertEquals(true, worked);
		System.out.println("\n");
		
		
        //assertTrue( true );
    }
	
	@Test
    public void test2ReadFile()
    {
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		assertEquals(true, worked);
		System.out.println("\n");
		
		
        //assertTrue( true );
    }
	
	@Test
    public void test3ReadFile()
    {
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		assertEquals(true, worked);
		System.out.println("\n");
		
		
        //assertTrue( true );
    }
	
	@Test
    public void test4ReadFile()
    {
		boolean worked = teams.readFile("Pref_Inputs4.csv");
		assertEquals(false, worked);
		System.out.println("\n");
		
		
        //assertTrue( true );
    }
	
	@Test
    public void test5ReadFile()
    {
		boolean worked = teams.readFile("Pref_Inputs5.csv");
		assertEquals(true, worked);
		System.out.println("\n");
		
		
        //assertTrue( true );
    }
	
	@Test
    public void test6ReadFile()
    {
		boolean worked = teams.readFile("Pref_Inputs6.csv");
		assertEquals(true, worked);
		System.out.println("\n");
		
		
        //assertTrue( true );
    }
	
	@Test
    public void test7ReadFile()
    {
		boolean worked = teams.readFile("Pref_Inputs7.csv");
		assertEquals(true, worked);
		System.out.println("\n");
		
		
        //assertTrue( true );
    }
	
	@Test
	public void test4MatrixRows()
	{
		boolean worked = teams.readFile("Pref_Inputs.csv");
		assertEquals(true, worked);
		int numRows = teams.getRowSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(9,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test5MatrixRows()
	{
		boolean worked = teams.readFile("Pref_Inputs.csv");
		assertEquals(true, worked);
		int numColumns = teams.getColumnSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(9,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test6MatrixRows()
	{
		teams.adj = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		teams.listMaker();
		assertEquals(true, worked);
		int numRows = teams.getRowSize();
		
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(6,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test7MatrixRows()
	{
		teams.adj = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		teams.listMaker();
		assertEquals(true, worked);
		int numColumns = teams.getColumnSize();
		
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(6,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test8MatrixRows()
	{
		teams.adj = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		teams.listMaker();
		assertEquals(true, worked);
		int numRows = teams.getRowSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(7,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test9MatrixRows()
	{
		teams.adj = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		teams.listMaker();
		assertEquals(true, worked);
		int numColumns = teams.getColumnSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(7,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test13MatrixRows()
	{
		teams.adj = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs5.csv");
		teams.listMaker();
		assertEquals(true, worked);
		int numRows = teams.getRowSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(6,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test14MatrixRows()
	{
		teams.adj = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs5.csv");
		teams.listMaker();
		assertEquals(true, worked);
		int numColumns = teams.getColumnSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(6,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test15MatrixRows()
	{
		teams.adj = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs6.csv");
		teams.listMaker();
		assertEquals(true, worked);
		int numRows = teams.getRowSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(6,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test16MatrixRows()
	{
		teams.adj = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs6.csv");
		teams.listMaker();
		assertEquals(true, worked);
		int numColumns = teams.getColumnSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(6,numColumns);
		System.out.println("\n");
	}
	
	public class BlankTest{
		
		@Before
		public void initialize(){
			teams = new PagerankTeams();
			teams.adj = new ArrayList<ArrayList<Integer>> ();
		}
		
		@Test
		public void test10MatrixRows()
		{
			boolean worked = teams.readFile("Pref_Inputs4.csv");
			assertEquals(true, worked);
			int numRows = teams.getRowSize();
			//System.out.println("Number of rows in matrix: " +numRows);
			assertEquals(true, worked);
			assertEquals(0,numRows);
			System.out.println("\n");
		}
	}
	
	@Test
	public void test11MatrixRows()
	{
		teams.adj = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs4.csv");
		//teams.listMaker();
		assertEquals(false, worked);
		int numColumns = teams.getColumnSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(false, worked);
		assertEquals(0,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test17MatrixRows()
	{
		boolean worked = teams.readFile("Pref_Inputs7.csv");
		assertEquals(true, worked);
		int numRows = teams.getRowSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(9,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test18MatrixRows()
	{
		boolean worked = teams.readFile("Pref_Inputs7.csv");
		assertEquals(true, worked);
		int numColumns = teams.getColumnSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(9,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test1ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs.csv");
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test1OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs.csv");
		teams.addAdjacencies(teams.namePref);
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(1);
		expected.add(1);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test2ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test2OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		teams.addAdjacencies(teams.namePref);
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(1);
		expected.add(1);
		expected.add(1);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test3ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test3OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		teams.addAdjacencies(teams.namePref);
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(1);
		expected.add(1);
		expected.add(0);
		expected.add(0);
		expected.add(1);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test4ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs4.csv");
		assertEquals(false, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test4OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs4.csv");
		teams.addAdjacencies(teams.namePref);
		assertEquals(false, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test5ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs5.csv");
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	
	
	@Test
	public void test5OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs5.csv");
		teams.addAdjacencies(teams.namePref);
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(0);
		expected.add(1);
		expected.add(1);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test6ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs6.csv");
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test6OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs6.csv");
		teams.addAdjacencies(teams.namePref);
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(0);
		expected.add(1);
		expected.add(1);
		expected.add(0);
	
	}
	
	@Test
	public void test7ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs7.csv");
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	
	
	@Test
	public void test7OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs7.csv");
		teams.addAdjacencies(teams.namePref);
		assertEquals(true, worked);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(0);
		expected.add(1);
		expected.add(1);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		assertEquals(expected,teams.adj.get(0));
		System.out.println("\n");
	}
	
	@Test
	public void test1ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs.csv");
		
		assertEquals(9, teams.namePref.size());
	}
	
	@Test
	public void test2ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		
		assertEquals(6, teams.namePref.size());
	}
	
	@Test
	public void test3ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		
		assertEquals(7, teams.namePref.size());
	}
	
	@Test
	public void test4ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs4.csv");
		
		assertEquals(1, teams.namePref.size());
	}
	
	@Test
	public void test5ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs5.csv");
		
		assertEquals(6, teams.namePref.size());
	}
	
	@Test
	public void test6ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs6.csv");
		
		assertEquals(6, teams.namePref.size());
	}
	
	@Test
	public void test7ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		boolean worked = teams.readFile("Pref_Inputs5.csv");
		
		assertEquals(6, teams.namePref.size());
	}
	
	@Test
	public void test1NonLinear()
	{
		
		boolean worked = teams.readFile("Pref_Inputs.csv");
		
		int [][] inputArray = new int [2][2];
		inputArray[0][0] = 0;
		inputArray[0][1] = 1;
		inputArray[1][0] = 1;
		inputArray[1][1] = 0;
		
		PageRank_NonLinear pr = new PageRank_NonLinear();
		pr.path = inputArray;
		double [] actualScores = pr.calc(pr.path.length);
		
		double actual = actualScores[0];
		double expected = 0.9915;
		
		
		assertEquals(actual, expected, 0.0000000000005);
		
	}
	
	@Test
	public void test2NonLinear()
	{
		
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		
		int [][] inputArray = new int [2][2];
		inputArray[0][0] = 0;
		inputArray[0][1] = 1;
		inputArray[1][0] = 1;
		inputArray[1][1] = 0;
		
		PageRank_NonLinear pr = new PageRank_NonLinear();
		pr.path = inputArray;
		double [] actualScores = pr.calc(pr.path.length);
		
		double actual = actualScores[0];
		double expected = 0.9915;
		
		
		assertEquals(actual, expected, 0.0000000000005);
		
	}
	
	@Test
	public void test3NonLinear()
	{
		
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		
		int [][] inputArray = new int [2][2];
		inputArray[0][0] = 0;
		inputArray[0][1] = 1;
		inputArray[1][0] = 1;
		inputArray[1][1] = 0;
		
		PageRank_NonLinear pr = new PageRank_NonLinear();
		pr.path = inputArray;
		double [] actualScores = pr.calc(pr.path.length);
		
		double actual = actualScores[0];
		double expected = 0.9915;
		
		
		assertEquals(actual, expected, 0.0000000000005);
		
	}
	
	@Test
	public void test4NonLinear()
	{
		
		boolean worked = teams.readFile("Pref_Inputs4.csv");
		
		int [][] inputArray = new int [2][2];
		inputArray[0][0] = 0;
		inputArray[0][1] = 1;
		inputArray[1][0] = 1;
		inputArray[1][1] = 0;
		
		PageRank_NonLinear pr = new PageRank_NonLinear();
		pr.path = inputArray;
		double [] actualScores = pr.calc(pr.path.length);
		
		double actual = actualScores[0];
		double expected = 0.9915;
		
		
		assertEquals(actual, expected, 0.0000000000005);
		
	}
	
	@Test
	public void test5NonLinear()
	{
		
		boolean worked = teams.readFile("Pref_Inputs5.csv");
		
		int [][] inputArray = new int [2][2];
		inputArray[0][0] = 0;
		inputArray[0][1] = 1;
		inputArray[1][0] = 1;
		inputArray[1][1] = 0;
		
		PageRank_NonLinear pr = new PageRank_NonLinear();
		pr.path = inputArray;
		double [] actualScores = pr.calc(pr.path.length);
		
		double actual = actualScores[0];
		double expected = 0.9915;
		
		
		assertEquals(actual, expected, 0.0000000000005);
		
	}
	
	@Test
	public void test6NonLinear()
	{
		
		boolean worked = teams.readFile("Pref_Inputs6.csv");
		
		int [][] inputArray = new int [2][2];
		inputArray[0][0] = 0;
		inputArray[0][1] = 1;
		inputArray[1][0] = 1;
		inputArray[1][1] = 0;
		
		PageRank_NonLinear pr = new PageRank_NonLinear();
		pr.path = inputArray;
		double [] actualScores = pr.calc(pr.path.length);
		
		double actual = actualScores[0];
		double expected = 0.9915;
		
		
		assertEquals(actual, expected, 0.0000000000005);
		
	}
	
	@Test
	public void test7NonLinear()
	{
		
		boolean worked = teams.readFile("Pref_Inputs7.csv");
		
		int [][] inputArray = new int [2][2];
		inputArray[0][0] = 0;
		inputArray[0][1] = 1;
		inputArray[1][0] = 1;
		inputArray[1][1] = 0;
		
		PageRank_NonLinear pr = new PageRank_NonLinear();
		pr.path = inputArray;
		double [] actualScores = pr.calc(pr.path.length);
		
		double actual = actualScores[0];
		double expected = 0.9915;
		
		
		assertEquals(actual, expected, 0.0000000000005);
		
	}
	
	@Test
	public void test1ArraySorter()
	{
		int[] nonLinearArray = new int [9];
		for(int c=0; c < 9; c++) //length of this file's result array 
			nonLinearArray[c] = c;
			
		
		int expected = nonLinearArray[0];
		int sortedValue = 0;
		assertEquals(sortedValue, expected);
		
		int expected2 = nonLinearArray[1];
		int sortedValue2 = 1;
		assertEquals(sortedValue2, expected2);
	}
	
	@Test
	public void test2ArraySorter()
	{
		int[] nonLinearArray = new int [7];
		for(int c=0; c < 7; c++) //length of this file's result array 
			nonLinearArray[c] = c;
			
		
		int expected = nonLinearArray[0];
		int sortedValue = 0;
		assertEquals(sortedValue, expected);
		
		int expected2 = nonLinearArray[1];
		int sortedValue2 = 1;
		assertEquals(sortedValue2, expected2);
		
	}
	
	@Test
	public void test3ArraySorter()
	{
		int[] nonLinearArray = new int [9];
		for(int c=0; c < 9; c++) //length of this file's result array 
			nonLinearArray[c] = c;
			
		
		int expected = nonLinearArray[0];
		int sortedValue = 0;
		assertEquals(sortedValue, expected);
		
		int expected2 = nonLinearArray[1];
		int sortedValue2 = 1;
		assertEquals(sortedValue2, expected2);
		
	}
	
	@Test
	public void test4ArraySorter()
	{
		int[] nonLinearArray = new int [10];
		for(int c=0; c < 10; c++) //length of this file's result array 
			nonLinearArray[c] = c;
			
		
		int expected = nonLinearArray[0];
		int sortedValue = 0;
		assertEquals(sortedValue, expected);
		
		int expected2 = nonLinearArray[1];
		int sortedValue2 = 1;
		assertEquals(sortedValue2, expected2);
		
	}
	
	@Test
	public void test5ArraySorter()
	{
		int[] nonLinearArray = new int [9];
		for(int c=0; c < 9; c++) //length of this file's result array 
			nonLinearArray[c] = c;
			
		
		int expected = nonLinearArray[0];
		int sortedValue = 0;
		assertEquals(sortedValue, expected);
		
		int expected2 = nonLinearArray[1];
		int sortedValue2 = 1;
		assertEquals(sortedValue2, expected2);
		
	}
	
	/*@Test
	public void testEmptyArrayList()
	{
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row0 = new ArrayList<Integer>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		arrayLength.add(row0);
		arrayLength.add(row1);
		int[][] arrayLengthCheck = teams.arrayListToArray(arrayLength);
		int[][] expected = {{},{}};
		assertEquals(arrayLengthCheck, expected);
	}
	*/
	
	
}
