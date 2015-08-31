import java.io.*;
import java.util.Scanner;

/**
 * Created by achowdhury on 6/30/2015.
 */
public class FileManupulation {
    public void SortFiles(String pathF1, String pathF2, String resultFile) {
        //variables for file 1
        FileInputStream inputStream1 = null;
        Scanner sc1 = null;
        Boolean increment1 = true;
        String line1 = null;

        //variables for file 2
        FileInputStream inputStream2 = null;
        Scanner sc2 = null;
        Boolean increment2 = true;
        String line2 = null;
        try{
            //read file 2
            inputStream1 = new FileInputStream(pathF1);
            sc1 = new Scanner(inputStream1, "UTF-8");
            //read file 2
            inputStream2 = new FileInputStream(pathF2);
            sc2 = new Scanner(inputStream2, "UTF-8");
            //keep looping till the end of both files
            while(true){
                //both files have ended
                if(sc1.hasNextLine()== false && sc2.hasNextLine()==false){
                    //get the last remaining word
                    if(! increment1){
                        SortLines(line1,null,resultFile);
                    }
                    if(! increment2){
                        SortLines(null,line2,resultFile);
                    }
                    break;
                }
                //file1 has ended
                if(sc1.hasNextLine()== false && sc2.hasNextLine()==true){
                    if(increment1)
                        line1 = null;
                    if(increment2)
                        line2 = sc2.nextLine();
                    if(line2.length() == 0)
                        line2 = null ;
                }
                //file2 has ended
                if(sc1.hasNextLine()== true && sc2.hasNextLine()==false){
                    if(increment2)
                        line2 = null;
                    if(increment1)
                        line1 = sc1.nextLine();
                    if(line1.length() == 0)
                        line1 = null ;
                }
                //none of the files have ended
                if(sc1.hasNextLine() && sc2.hasNextLine()){
                    //file 1 has the smaller value so increment to get next line
                    if(increment1){
                        line1 = sc1.nextLine();
                        if(line1.length() == 0)
                            line1 = null ;
                    }
                    //file 2 has the smaller value so increment to get next line
                    if(increment2){
                        line2 = sc2.nextLine();
                        if(line2.length() == 0)
                            line2 = null ;
                    }
                }
                //sort alphabetically
                Boolean[] result = SortLines(line1,line2,resultFile);
                //checks which line to increment next based on the array values
                increment1 = result[0];
                increment2 = result[1];
            }
        }
        catch(FileNotFoundException ex){
            System.err.println(ex.getMessage());
        }
        finally{
            try{
                if(inputStream1 != null) inputStream1.close();
                if(inputStream2 != null) inputStream2.close();
                if(sc1 != null) sc1.close();
                if(sc2 != null) sc2.close();
            }
            catch(IOException ex){
                System.err.println(ex.getMessage());
            }
        }
    }

    public Boolean[] SortLines(String s1, String s2, String resultFile){
        Boolean[] incremental = new Boolean[2];
        if(s1 == null && s2 == null)
        {
            incremental[0]=false;
            incremental[1]=false;
            return incremental;
        }
        if(s1 == null){
            incremental[0]=false;
            incremental[1]=true;
            WriteToFile(s2,resultFile);
            return incremental;
        }
        if(s2 == null){
            incremental[0]=true;
            incremental[1]=false;
            WriteToFile(s1,resultFile);
            return incremental;
        }
        int result = s1.split(",")[0].compareToIgnoreCase(s2.split(",")[0]);
        if(result < 0){
            //s1 is less
            incremental[0]=true;
            incremental[1]=false;
            WriteToFile(s1,resultFile);
        }
        else if(result == 0){
            //s1 is equal to s2
            incremental[0]=true;
            incremental[1]=true;
            WriteToFile(s1,resultFile);
            WriteToFile(s2,resultFile);
        }
        else{
            //s2 is less
            incremental[0]=false;
            incremental[1]=true;
            WriteToFile(s2,resultFile);
        }
        return incremental;
    }

    public void WriteToFile(String word, String resultFileName){
        try{
            File newFile = new File(resultFileName);
            if(!newFile.exists()) {
                newFile.createNewFile();
            }
            FileOutputStream stream = new FileOutputStream(newFile, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(stream));
            bw.write(word);
            bw.newLine();
            bw.close();
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }

    public void DeleteFile(String fileName){
        File f = new File(fileName);
        if(f.exists())
            f.delete();
    }

}
