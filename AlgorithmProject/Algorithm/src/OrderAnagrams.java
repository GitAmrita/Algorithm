import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by achowdhury on 7/17/2015.
 */
public class OrderAnagrams {

    public String[] a = new String[] {"fish","shif","milk","doll","ilmk","isfh"};
    Map<String, Integer> graph = new HashMap<String, Integer>() ;
    public void InsertWord(String word){
        graph.put(word,1);
    }
    public boolean isAnagram(String word){
        return graph.get(word) != null ;
    }
    public void Swap(int first, int second){
        String temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
    public void PrintArray(){
        for(int i = 0; i< a.length; i++){
            System.out.println(a[i]);
        }
    }

    public void GroupAnagrams(){
        int pivot = 0;
        while(pivot < a.length){
            char[] chars = a[pivot].toCharArray();
            Arrays.sort(chars);
            InsertWord(new String(chars));
            for(int i = pivot + 1; i < a.length ; i++){
                char[] tempChar = a[i].toCharArray();
                Arrays.sort(tempChar);
                if(isAnagram(new String(tempChar))){
                    pivot ++ ;
                    if(i != pivot)
                        Swap(pivot,i);
                }
            }
            pivot ++ ;
        }
        PrintArray();
    }
}
