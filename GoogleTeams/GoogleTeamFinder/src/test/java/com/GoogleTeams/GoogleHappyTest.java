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
public class GoogleHappyTest 
{
	
	private int rowNumber;
	private int columnNumber;
    GoogleHappy teams;
	
	@Rule 
	public TestRule watcher =
		new TestWatcher() {
			protected void starting(Description description){
				System.out.println("Starting test: " + description.getMethodName());
		}
	};
		
	@Before
	public void initialize(){
		teams = new GoogleHappy();
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
		assertEquals(true, worked);
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
	
	public class BlankTest{
		
		@Before
		public void initialize(){
			teams = new GoogleHappy();
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
		assertEquals(true, worked);
		int numColumns = teams.getColumnSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test1ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs.csv");
		assertEquals(true, worked);
		int numRows = teams.zeroChecker();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test1OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs.csv");
		assertEquals(true, worked);
		int numColumns = teams.oneChecker();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test2ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		assertEquals(true, worked);
		int numRows = teams.zeroChecker();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test2OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		assertEquals(true, worked);
		int numColumns = teams.oneChecker();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test3ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		assertEquals(true, worked);
		int numRows = teams.zeroChecker();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test3OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		assertEquals(true, worked);
		int numColumns = teams.oneChecker();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test4ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs4.csv");
		assertEquals(true, worked);
		int numRows = teams.zeroChecker();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test4OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs4.csv");
		assertEquals(true, worked);
		int numColumns = teams.oneChecker();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test5ZeroCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs5.csv");
		assertEquals(true, worked);
		int numRows = teams.zeroChecker();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test5OneCheck()
	{
		boolean worked = teams.readFile("Pref_Inputs5.csv");
		assertEquals(true, worked);
		int numColumns = teams.oneChecker();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test1ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		//boolean worked = teams.readFile("Pref_Inputs.csv");
		ArrayList<Integer> row0 = new ArrayList<Integer>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row0.add(0);
		row0.add(0);
		row1.add(1);
		row1.add(1);
		arrayLength.add(row0);
		arrayLength.add(row1);
		int[][] arrayLengthCheck = teams.arrayListToArray(arrayLength);
		int[][] expected = {{0,0},{1,1}};
		assertEquals(arrayLengthCheck, expected);
	}
	
	@Test
	public void test2ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		//boolean worked = teams.readFile("Pref_Inputs.csv");
		ArrayList<Integer> row0 = new ArrayList<Integer>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row0.add(0);
		row0.add(0);
		row1.add(1);
		row1.add(1);
		arrayLength.add(row0);
		arrayLength.add(row1);
		int[][] arrayLengthCheck = teams.arrayListToArray(arrayLength);
		int[][] expected = {{0,0},{1,1}};
		assertEquals(arrayLengthCheck, expected);
	}
	
	@Test
	public void test3ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		//boolean worked = teams.readFile("Pref_Inputs.csv");
		ArrayList<Integer> row0 = new ArrayList<Integer>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row0.add(0);
		row0.add(0);
		row1.add(1);
		row1.add(1);
		arrayLength.add(row0);
		arrayLength.add(row1);
		int[][] arrayLengthCheck = teams.arrayListToArray(arrayLength);
		int[][] expected = {{0,0},{1,1}};
		assertEquals(arrayLengthCheck, expected);
	}
	
	@Test
	public void test4ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		//boolean worked = teams.readFile("Pref_Inputs.csv");
		ArrayList<Integer> row0 = new ArrayList<Integer>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row0.add(0);
		row0.add(0);
		row1.add(1);
		row1.add(1);
		arrayLength.add(row0);
		arrayLength.add(row1);
		int[][] arrayLengthCheck = teams.arrayListToArray(arrayLength);
		int[][] expected = {{0,0},{1,1}};
		assertEquals(arrayLengthCheck, expected);
	}
	
	@Test
	public void test5ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		//boolean worked = teams.readFile("Pref_Inputs.csv");
		ArrayList<Integer> row0 = new ArrayList<Integer>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row0.add(0);
		row0.add(0);
		row1.add(1);
		row1.add(1);
		arrayLength.add(row0);
		arrayLength.add(row1);
		int[][] arrayLengthCheck = teams.arrayListToArray(arrayLength);
		int[][] expected = {{0,0},{1,1}};
		assertEquals(arrayLengthCheck, expected);
	}
	
	@Test
	public void test6ArrayListSize()
	{
		
		ArrayList<ArrayList<Integer>> arrayLength = new ArrayList<ArrayList<Integer>>();
		//boolean worked = teams.readFile("Pref_Inputs.csv");
		ArrayList<Integer> row0 = new ArrayList<Integer>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row0.add(0);
		row0.add(0);
		row1.add(1);
		row1.add(1);
		arrayLength.add(row0);
		arrayLength.add(row1);
		int[][] arrayLengthCheck = teams.arrayListToArray(arrayLength);
		int[][] expected = {{0,0},{1,1}};
		assertEquals(arrayLengthCheck, expected);
	}
