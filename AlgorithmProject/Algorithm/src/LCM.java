/**
 * Created by achowdhury on 6/8/2015.
 */
public class LCM {
    public void FindLCM(){
        int a = 23;
        int b = 47;
        if(a == b)
            System.out.println(a);
        int min; int max;
        if(a>b){
            max = a ; min = b;
        }
        else {
            max = b ; min = a;
        }
        int i = max;
        while(true){
            if(i % min == 0 && i % max ==0){
                System.out.println(i);
                break;
            }
            if(i == max * min){
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
