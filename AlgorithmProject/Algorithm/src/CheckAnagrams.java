import java.util.HashMap;
import java.util.Map;

/**
 * Created by achowdhury on 7/17/2015.
 */
public class CheckAnagrams {
    Map<Character, Integer> graph = new HashMap<Character, Integer>() ;
    String s1 = "Eleven plus two";
    String s2 = "Twelve plus one";

    public void InsertFirstString(){
        for(char c : s1.toCharArray() ){
            if(c != ' ')
            {
                if(graph.get(c) == null)
                    graph.put(c,1);
                else
                    graph.put(c,graph.get(c) + 1);
            }
        }
    }
    public boolean CheckSecondString(){
        for(char c : s1.toCharArray() ){
            if(c != ' '){
                if(graph.get(c) == null)
                    return false;
                else if(graph.get(c) == 0 )
                    return false;
                else
                    graph.put(c,graph.get(c) - 1);
            }
        }
        return true;
    }
    public void IsAnagram(){
        if(s1 == null && s2 == null)
            System.out.println("anagram");
        else if(s1.isEmpty() && s2.isEmpty())
            System.out.println("anagram");
        else if(s1 == null || s1.isEmpty())
            System.out.println("not anagram");
        else if(s2 == null || s2.isEmpty())
            System.out.println("not anagram");
        else if(s1.length() != s2.length())
            System.out.println("not anagram");
        else{
            InsertFirstString();
            if(CheckSecondString())
                System.out.println("anagram");
            else
                System.out.println("not anagram");
        }
    }
}
