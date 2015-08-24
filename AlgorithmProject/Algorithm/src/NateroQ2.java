import java.io.*;
import java.util.*;

/**
 * Created by achowdhury on 6/30/2015.
 */
/*Summary of my thought process
1. Since the files are so big , create chunks of data from each file which is equal to the available memory and create temp files and sort them
2. Then merge all the sorted chunks to create one sorted file
3.Follow the steps above for both the files one at a time
4. Now we have 2 sorted files , output the values in a third file going line by line for each file

NOTE: This problem could have been easily solved using hash table if the files were small enough to be contained in memory
Could have used K merge sort for merging the individual sorted chunks, however used 2 Merge since that is what I used for the Q1
*/

public class NateroQ2 {
    //set chunk size
    private static int CHUNK_SIZE = 100;
    //Break file in chunk and sort each chunk and create temp files = sorted chunk
    public List<String> SortedChunksSplitFile(String filePath, int chunkSize, String fileName, String tempChunkFilePrefix){
        List<String> buffer = new ArrayList<String>();
        List<String> fileList = new ArrayList<String>();
        int size = 0;
        int chunkNo = 0;
        try{
            FileInputStream stream = new FileInputStream(filePath);
            Scanner sc = new Scanner(stream, "UTF-8");
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if (size + line.length() >= chunkSize){
                    chunkNo ++ ;
                    size = 0;
                    fileList.add(OutputBuffer(buffer, fileName + chunkNo,tempChunkFilePrefix));
                    buffer.clear();
                }
                size += line.length() ;
                buffer.add(line);
            }
            if(! buffer.isEmpty()){
                chunkNo ++ ;
                fileList.add(OutputBuffer(buffer,fileName + chunkNo,tempChunkFilePrefix));
            }
        }
        catch(FileNotFoundException ex){System.err.println(); }
        return fileList;
    }

    public String OutputBuffer(List<String> buffer, String chunkNo, String tempChunkFilePrefix)
    {
        Collections.sort(buffer, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.split(",")[0].compareToIgnoreCase(s2.split(",")[0]);
            }
        });
        String tempFileName = tempChunkFilePrefix + chunkNo+ ".txt";

        try{
            File tempFile = new File(tempFileName);
            if(!tempFile.exists()) {
                tempFile.createNewFile();
            }
            FileOutputStream stream = new FileOutputStream(tempFile, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(stream));
            for(String pair : buffer){
                bw.write(pair);
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
        return tempFileName;
    }

    //Merge each sorted chunk. chunk1 merges with chunk2 creates temp3. temp3 merges with chunk3 .....till there are chunks available
    public String MergeFiles(String file1, String file2,int mergeLoop, String resultFilePrefix){
        String resultFile =resultFilePrefix+ mergeLoop + ".txt";
        FileManupulation fm = new FileManupulation();
        fm.SortFiles(file1,file2,resultFile);
        return resultFile;
    }

    //Delete temp files. clean up step
    public void DeleteFile(List<String> files){
        FileManupulation fm = new FileManupulation();
        for(String f: files)
            fm.DeleteFile(f);
    }

    //Step1-3 Break the files in chunks and sort
    public String SortFileInChunk(String fileName, String filePath,String tempChunkFilePrefix,String mergeFilePrefix){
        List<String> tempMergeFiles = new ArrayList<String>();
        List<String> chunkFiles =SortedChunksSplitFile(filePath,CHUNK_SIZE,fileName,tempChunkFilePrefix);
        //memory is sufficient for the file
        if(chunkFiles.size()==1){
            return chunkFiles.get(0);
        }
        String file1 = chunkFiles.get(0);
        String file2 = chunkFiles.get(1);
        String resultTemp =MergeFiles(file1,file2,1,mergeFilePrefix+fileName);
        tempMergeFiles.add(resultTemp);
        file2=resultTemp;
        for(int i = 2 ; i < chunkFiles.size(); i++){
            file1 = chunkFiles.get(i);
            String resultTemp1 =MergeFiles(file1,file2,i,mergeFilePrefix+fileName);
            file2 = resultTemp1;
            if(i < chunkFiles.size()-1)
                tempMergeFiles.add(resultTemp1);
        }
        String sortedFile = file2 ;
        DeleteFile(chunkFiles);
        DeleteFile(tempMergeFiles);
        return sortedFile;
    }

    //Step 4 final file
    public void GetFinalOutputFile(String f1, String f2, String finalFile){
        FileManupulation fm = new FileManupulation();
        List<String> deleteFile=Arrays.asList(finalFile);
        DeleteFile(deleteFile);
        FileInputStream inputStream1 = null;
        Scanner sc1 = null;
        String line1 = null;
        //variables for file 2
        FileInputStream inputStream2 = null;
        Scanner sc2 = null;
        String line2 = null;

        try{
            //read file 2
            inputStream1 = new FileInputStream(f1);
            sc1 = new Scanner(inputStream1, "UTF-8");
            //read file 2
            inputStream2 = new FileInputStream(f2);
            sc2 = new Scanner(inputStream2, "UTF-8");
            //keep looping till the end of both files
            while(sc1.hasNextLine() && sc2.hasNextLine()){
                line1 = sc1.nextLine().split(",")[1];
                line2 = sc2.nextLine().split(",")[1];
                fm.WriteToFile(line1 + " ," + line2,finalFile);
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
        //delete the temp merged files
        deleteFile=Arrays.asList(f1,f2);
        DeleteFile(deleteFile);
        System.out.println("result can be found at : " + finalFile);
    }

    //program started here
    public void AnswerQ2(){
        File chunkDir = new File(System.getProperty("user.dir") + "/Chunk");
        File mergeDir = new File(System.getProperty("user.dir") + "/Merge");
        try{
            if (!chunkDir.exists())
                chunkDir.mkdir();
            if (!mergeDir.exists())
                mergeDir.mkdir();
        }
        catch(SecurityException ex){
            System.err.println(ex.getMessage());
        }
        //*******************FILE PATHS******************************
        //final output file
        String finalFile=System.getProperty("user.dir") + "/ResultFileQ2.txt";
        //input source files
        String f1=System.getProperty("user.dir") + "/FileQ21.txt";
        String f2=System.getProperty("user.dir") + "/FileQ22.txt";
        //temp file prefix for breaking input file into chunks
        String tempFileNameChunk =System.getProperty("user.dir") + "/Chunk/";
        //temp file prefix for merging chunks
        String mergeFilePrefix =System.getProperty("user.dir") + "/Merge/";
        //*************END OF FILE PATH SETTING***********************************************

        String sortedFile1 = SortFileInChunk("File1_", f1,tempFileNameChunk,mergeFilePrefix );
        String sortedFile2 = SortFileInChunk("File2_", f2,tempFileNameChunk ,mergeFilePrefix);
        GetFinalOutputFile(sortedFile1,sortedFile2,finalFile);

        //Delete the temp directories created
        chunkDir.delete();
        mergeDir.delete();
    }
}
