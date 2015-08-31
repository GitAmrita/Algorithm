import java.util.ArrayList;
import java.util.List;

/**
 * Created by achowdhury on 7/19/2015.
 */
public class PermutationStr {
    public List<String> Permutations(String prefix, String str){
        List<String> permutations = new ArrayList<String>();
        int n = str.length();
        if(n == 0)
            permutations.add(prefix);
        else{
            for(int i=0; i< n; i++){
                List<String> temp = Permutations(prefix + str.charAt(i),str.substring(0,i) + str.substring(i + 1, n));
                permutations.addAll(temp);
            }
        }
        return permutations;
    }

    public void GeneratePermutations(){
        String s = "etm" ;
        List<String> res = Permutations("",s);
        for(String i : res){
            System.out.println(i);
        }
    }
}
