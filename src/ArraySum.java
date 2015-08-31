import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by achowdhury on 7/18/2015.
 */
//from an array of numbers find if the sum of any 2 members exists in the array.
public class ArraySum {
    int[]a = new int [] {-2, 5, 1, -1, 4, 3};
    Map<Integer,Integer> tbl = new HashMap<Integer,Integer>();
    public void InsertArrayInHash(){
        for(int i = 0; i < a.length; i++)
            tbl.put(a[i],1);
    }
    public boolean IsSumPresent(int val){
        return tbl.get(val) != null;
    }
    public void CheckSumPresent(){
        InsertArrayInHash();
        for(int i =0 ; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if(IsSumPresent(a[i] + a[j]))
                    System.out.println("first num : " + a[i] + " second num : " + a[j]);
            }
        }
    }
}
