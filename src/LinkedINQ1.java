import java.util.*;
import java.util.LinkedList;

/**
 * Created by achowdhury on 7/9/2015.
 */
//http://www.careercup.com/question?id=5725709041401856
public class LinkedINQ1 {

    public void MinDist(List<String> str, String t1, String t2){
        Boolean found1 = false;
        Boolean found2= false;
        int min1 =0 ;
        int min2 =0 ;
        for(int i =0 ; i < str.size(); i++){
            String currVal = str.get(i);
            if(currVal == t1){
                if(found1 == false ||found2 == false){found1 = true; min1 = i;}
                else
                   min1= GetSmallestDist(min1, min2, i);
            }
            if(currVal == t2){
                found2 = true;
                if(found1 == false ||found2 == false){found2 = true; min2 = i;}
                else
                    min2= GetSmallestDist(min2, min1, i);
            }
        }
        if(found1 == false || found2 == false){
            System.out.println("words not found");
            return;
        }

        int diff = min1-min2;
        System.out.println("min1 : " + min1 );
        System.out.println("min2 : " + min2 );
        System.out.println("min1 - min2 = " + Math.abs(diff) );
    }

    public int GetSmallestDist(int oldPos, int fixedPos, int newPos){
        int val1 = oldPos - fixedPos;
        int val2 = newPos -fixedPos ;
        if(Math.abs(val1) < Math.abs(val2))
            return oldPos ;
        else
            return newPos ;
    }

    public void CallMinDist(){
        List<String> strList = new LinkedList<String>();
        strList.add("the");
        strList.add("quick");
        strList.add("brown");
        strList.add("fox");
        strList.add("quick");
        MinDist(strList, "fox", "quick");
    }
}
