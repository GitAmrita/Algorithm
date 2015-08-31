import java.util.*;
import java.util.LinkedList;

/**
 * Created by achowdhury on 7/27/2015.
 */
/*
Find all the repeating sub-string sequence of specified length in a large string sequence.
The sequences returned i.e. the output must be sorted alphabetically.
For e.g.
Input String: "ABCACBABC"
repeated sub-string length: 3
Output: ABC
Input String: "ABCABCA"
repeated sub-string length: 2
Output: AB, BC, CA
* */
public class LinkedInQIFailed {
    public String str = "ABCABCA";
    public int length = 2;
    public Map<String,Integer> tbl = new HashMap<String, Integer>();
    public List<String> resultList = new LinkedList<String>();
    public void AddToHashTable(String s){
        if(tbl.get(s) == null)
                tbl.put(s,1);
        else
            tbl.put(s,tbl.get(s) + 1);
        if(tbl.get(s) == 2)
            resultList.add(s);
    }
    public void FindRepeats(){
        int i =0 ;
        while(i <= str.length() - 2){
            String pattern = "";
            for(int j =i ; j < i + length ; j ++){
               pattern = pattern + Character.toString(str.charAt(j)) ;
            }
            AddToHashTable(pattern);
            i ++;
        }
        Collections.sort(resultList);
        for(String p : resultList){
            System.out.println(p);
        }
    }
}
