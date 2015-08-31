import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Created by achowdhury on 6/29/2015.
 */
//Write a program that reads in three files, each containing sorted lists of words,
// and outputs a single file containing the single sorted list containing all of the words from the three files.

/*Summary of my thought process
* 1. Take 2 files f1 and f2
* 2. Since the files cannot be loaded completely in memory read one string each from the two files
* 3. Compare the string from f1 and string from f2 and write to a temp file which ever string is smaller alphabetically say string1
* 4. Read the next string from f1 without altering the string2 from f2
* 5. Repeat steps 3 to 4 till both the files are finished reading
* 6. Now repeat all the steps comparing the file 3 and the temp file and output in a result file
* 7. Delete the temp file*/


public class NateroQ1 {
    FileManupulation fm = new FileManupulation();
    //Reads two files line by line and compares each line
    private void SortFiles(String pathF1, String pathF2, String resultFile) {
        fm.SortFiles(pathF1,pathF2,resultFile);
    }

    //sorts two lines belonging to each file and returns which file gets written
    private Boolean[] SortLines(String s1, String s2, String resultFile){
        return fm.SortLines(s1,s2,resultFile);
    }

    //write to result file
    private void WriteToFile(String word, String fileName){
        fm.WriteToFile(word,fileName);
    }

    //delete any intermediate file if created
    private void DeleteFile(String fileName){
        fm.DeleteFile(fileName);
    }

    //entry point of the program
    public void AnswerQ1(){
        //*******************FILE PATHS******************************
        //INPUT FILES
        String f1=System.getProperty("user.dir") + "/FileQ11.txt";
        String f2=System.getProperty("user.dir") + "/FileQ12.txt";
        String f3=System.getProperty("user.dir") + "/FileQ13.txt";

        //TEMP FILE REQUIRED TO MERGE THE 1ST AND 2ND FILE
        String tempFile=System.getProperty("user.dir") + "/Temp.txt";

        //OUTPUT FILE
        String result=System.getProperty("user.dir") + "/ResultFileQ1.txt";
        //*************END OF FILE PATH SETTING***********************************************
        DeleteFile(result);
        SortFiles(f1,f2,tempFile);
        SortFiles(f3,tempFile,result);
        DeleteFile(tempFile);
        System.out.println("result can be found at : " + result);
    }
}
