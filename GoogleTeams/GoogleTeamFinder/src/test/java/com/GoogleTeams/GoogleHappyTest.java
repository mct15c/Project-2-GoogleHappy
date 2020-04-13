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
	public void test4MatrixRows()
	{
		boolean worked = teams.readFile("Pref_Inputs.csv");
		assertEquals(true, worked);
		int numRows = teams.getRowSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numRows);
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
		assertEquals(0,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test6MatrixRows()
	{
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		assertEquals(true, worked);
		int numRows = teams.getRowSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test7MatrixRows()
	{
		boolean worked = teams.readFile("Pref_Inputs2.csv");
		assertEquals(true, worked);
		int numColumns = teams.getColumnSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numColumns);
		System.out.println("\n");
	}
	
	@Test
	public void test8MatrixRows()
	{
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		assertEquals(true, worked);
		int numRows = teams.getRowSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numRows);
		System.out.println("\n");
	}
	
	@Test
	public void test9MatrixRows()
	{
		boolean worked = teams.readFile("Pref_Inputs3.csv");
		assertEquals(true, worked);
		int numColumns = teams.getColumnSize();
		//System.out.println("Number of rows in matrix: " +numRows);
		assertEquals(true, worked);
		assertEquals(0,numColumns);
		System.out.println("\n");
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
	
	@Test
	public void test11MatrixRows()
	{
		boolean worked = teams.readFile("Pref_Inputs4.csv");
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
}
