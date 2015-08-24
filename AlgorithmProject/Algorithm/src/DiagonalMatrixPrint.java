/**
 * Created by achowdhury on 7/18/2015.
 */
public class DiagonalMatrixPrint {
    //http://www.careercup.com/question?id=5661939564806144
    int[][] a = new int [][]{{1,2,3},{4,5,6},{7,8,9}};
    public void LoopMartix(){
        int rowMax = a.length ;
        int colMax = a[0].length ;
        int row = 0;
        for(int i = 0; i< colMax ; i++){
            PrintMatrix(row, i, rowMax, colMax);
        }
        int col = colMax - 1;
        for(int i = 1; i< rowMax ; i++ ){
            PrintMatrix(i, col, rowMax, colMax);
        }
    }
    public void PrintMatrix(int row, int col, int rowMax, int colMax){
        System.out.println();
        while(row < rowMax && col >= 0 && col < colMax){
            System.out.print(a[row][col]);
            System.out.print(" ");
            row ++ ;
            col --;
        }
    }
}
