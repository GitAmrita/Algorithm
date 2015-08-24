import java.util.Stack;

/**
 * Created by achowdhury on 7/18/2015.
 */
//Write a method which transforms an integer into a binary number, no libraries using (on a whiteboard).
public class IntToBinary {
    public void Convert(){
        int num = 50;
        Stack<Integer> st = new Stack<Integer>();
        while(num / 2 >= 1){
            int quo = num / 2;
            int rem = num % 2;
            st.push(rem);
            num = quo;
        }
        st.push(num % 2);
        while( !st.isEmpty()){
            System.out.print(st.pop());
        }
    }
}
