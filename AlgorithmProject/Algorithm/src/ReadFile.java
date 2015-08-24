import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 * Created by achowdhury on 6/18/2015.
 */
public class ReadFile {

    public void ReadLastLines(){
        String fileName ="C:\\Users\\achowdhury\\Documents\\Docs\\KY.txt";
        String line = null;
        int noOfLines = 2;
        int count =0;
        Stack<String> s = new Stack<String>();
        try{
            FileReader reader = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(reader);
            while((line = buffer.readLine()) != null){
                System.out.println(line);
                s.push(line);
            }
            System.out.println("************************");
            while(count <= noOfLines){
                count ++ ;
                System.out.println(s.pop());
            }
        }
        catch(FileNotFoundException ex){

        }
        catch(IOException ex){

        }
    }
}
