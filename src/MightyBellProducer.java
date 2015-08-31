import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by achowdhury on 8/14/2015.
 */
public class MightyBellProducer {

    public void ReadFile(String filePath){
        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(filePath));
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void Start(){
        ReadFile("C:\\Users\\achowdhury\\Documents\\OwnItInterview\\events-20150626T150000Z_20150626T155959Z.json");
    }
}
