/**
 * Created by achowdhury on 6/6/2015.
 */
public class BinarySearch {

    public int[] a = new int[]{-2,1,3,6};
    public boolean IsNoFindable(int target){
        for(int i = 0 ; i < a.length ; i++){
            int s1= a[i];
            int s2 = target - s1;
            if(FindS2(s2,i))
                return true;
        }
        return false;
    }

    public boolean FindS2(int no, int i){
        int min=i;
        int max = a.length - 1;
        if(no > max || no < min)
            return false;
        if(a[min]==no || a[max] == no)
            return true;
        while(min <= max){
            int avg=(max + min )/2;
            if(no == a[avg])
                return true;
            if(no < a[avg] ){
                max = avg -1 ;
            }
            else{
                min = avg + 1;
            }
        }
        return false;
    }
}
