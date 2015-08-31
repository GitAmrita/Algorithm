/**
 * Created by achowdhury on 7/8/2015.
 */
public class FindTriangle {

    //make sure the array is always sorted
    public int[] a =  new int[]{10, 21, 22, 100, 101, 200, 300};
    public void getTriangle(){
        int k = 0 ; int j =0;
        int len = a.length;
        for(int i =0 ; i  <= len-2 ; i++){
            k = i + 2;
            for(j = i+1 ; j < len -1 ; j++){
                if(a[i] + a[j] > a[k]){
                    System.out.println(a[i] + "," + a[j] + "," + a[k]);
                }
                k++;
            }
        }
    }
}