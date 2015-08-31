/**
 * Created by achowdhury on 6/28/2015.
 */
//http://www.geeksforgeeks.org/find-number-of-triangles-possible/
public class FormTriangle {
//sort array in ascending
    int[] a = new int[]{7,8,9,10};
        //{10, 21, 22, 100, 101, 200, 300};

    public void GetTriangle(){
        for(int i =0; i<a.length - 2;i++){
            int k = i + 2;
            for(int j = i + 1 ; j< a.length; j++){
                while(k < a.length){
                    if(a[i] + a[j] > a[k] && j!=k){
                        System.out.println("(" + a[i] + ',' + a[j] + ',' + a[k] + ")");
                        k++ ;
                    }
                    else
                        break;
                }
            }
        }
    }
}
