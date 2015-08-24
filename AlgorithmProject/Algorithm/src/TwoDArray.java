/**
 * Created by achowdhury on 6/21/2015.
 */
public class TwoDArray {
    public void CountMaxSetRow(){
        String max = "";
        int noOfSet=0;
        int[][] array = new int[][]{
                {0,0,0,1,1},
                {0,1,1,1,1},
                {1,1,1,1,1}
        };
        for(int i = 0; i < array.length;i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j]==1){
                  int  noOfSetLocal = array[i].length - j;
                    if(noOfSet < noOfSetLocal){
                        noOfSet = noOfSetLocal;
                        max = Integer.toString(i);
                    }
                    break;
                }
            }
        }
        System.out.println(max);
    }
}
