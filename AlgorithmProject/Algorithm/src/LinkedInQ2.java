/**
 * Created by achowdhury on 7/9/2015.
 */
//http://www.careercup.com/question?id=5826758028820480
public class LinkedInQ2 {

    public void FindProduct(){
        int[] a = new int[]{3, 0, 4, 1};
        int[] res = new int[a.length];
        int product = 1;
        for(int i = 0 ; i < a.length ; i++){
            product = 1;
            for(int j = 0 ; j < a.length ; j++){
                if(j != i)
                    product = product * a[j];
            }
            res[i] = product;
        }
        for(int p : res)
            System.out.println(p);
    }
}
