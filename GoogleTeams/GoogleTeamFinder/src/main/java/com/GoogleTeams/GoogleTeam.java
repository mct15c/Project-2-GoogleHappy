import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GoogleTeam {

    public boolean readFile(String file) {

        String csvFile = file;
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] name = line.split(cvsSplitBy);

				if (name.length > 1){
					System.out.print(name[0]);
					for (int i = 1; i < name.length; i++){
						System.out.print("," + name[i]);
					}
					System.out.print("\n");
				}

                //System.out.println(name[0]);

            }
			
			return true;

        } catch (IOException e) {
            e.printStackTrace();
			return false;
        }

    }

}

/**
 * Hello world!
 *
 
public class GoogleTeam 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
*/
