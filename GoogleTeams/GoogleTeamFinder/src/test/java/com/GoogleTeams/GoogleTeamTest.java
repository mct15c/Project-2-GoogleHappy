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
public class GoogleTeamTest 
{
    GoogleTeam teams;
	
	@Rule 
	public TestRule watcher =
		new TestWatcher() {
			protected void starting(Description description){
				System.out.println("Starting test: " + description.getMethodName());
		}
	};
		
	@Before
	public void initialize(){
		teams = new GoogleTeam();
	}
	
    @Test
    public void test1ReadFile()
    {
		boolean worked = teams.readFile("Pref_Inputs.csv");
		assertEquals(true, worked);
		System.out.println("\n");
		
		
        //assertTrue( true );
    }
}
	
/*	@Test
	public void test2PageRank()
	{
		boolean worked = teams.
		assertEquals(true, worked);
		System.out.println("\n");
	}
}
*/