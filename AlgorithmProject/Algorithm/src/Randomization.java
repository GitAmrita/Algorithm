import java.util.Random;

/**
 * Created by achowdhury on 7/10/2015.
 */
public class Randomization {
    public void RandGenerate(){
        Random rn = new Random();
        int []a = new int[] {1,2,3,4,5,6,7,8};
        for(int i = 0 ; i < a.length ; i++){
            int randomIndex = rn.nextInt(a[a.length - 1] - i + 1) + i ;//(max - min + 1) + min
            int temp = a[i];
            a[i]=a[randomIndex];
            a[randomIndex] = temp;
        }
        for(int i = 0 ; i < a.length ; i++)
            System.out.println(a[i]);
    }
}
