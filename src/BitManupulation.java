/**
 * Created by achowdhury on 6/10/2015.
 */
public class BitManupulation {

    //determine the number of bits required to convert int a to int b
    public void BitSwapReqd()
    {
        ConvertToBit();
        int a = 9; int b = 5;
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >> 1)//xor a and b and then right shift to count bit = 1
        {   count += c & 1; }
        System.out.println(count);
    }

    public void ConvertToBit(){
        int s = 17;
        int quotient ;
        int array[] = new  int [32];
        int i=0;
        while(true){
            quotient = s / 2;
            if(s % 2 ==0 )
                array[i] = 0;
            else array[i]=1;
            i ++;
            s = quotient ;
            if(s == 1){
                array[i]=1;
                break;
            }
        }
        for(int p = 0 ; p <= i; p++){
          System.out.print(array[p]) ;
        }
    }
}
