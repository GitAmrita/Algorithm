/**
 * Created by achowdhury on 7/17/2015.
 */
//Given an array, shift all the zeros to the right of the array, without disrupting order of the non zero elements  Ooyala interview
public class RightShift0InArray {
    int [] a = new int []{0,0,0,0,1,2,3,4,};
    public void MoveElements(){
        PrintArray();
        int firstNonZeroPos = -1;
        for(int i = a.length-1 ; i>=0; i--){
            if(a[i] != 0 && firstNonZeroPos == -1)
                firstNonZeroPos = i;
            else if(a[i] == 0 && firstNonZeroPos > -1){
                SwapRight(i, firstNonZeroPos);
                firstNonZeroPos --;
            }
            else continue;
        }
        PrintArray();
    }

    public void SwapRight(int zeroPos, int nonZeroPos){
        for(int i = zeroPos; i < nonZeroPos; i++){
            int temp = a[i];
            a[i]= a[i + 1];
            a[i + 1] = temp;
        }
    }

    public void PrintArray(){
        for(int i = 0 ; i< a.length;i++ )
            System.out.print(a[i]);
        System.out.println();
    }
}
