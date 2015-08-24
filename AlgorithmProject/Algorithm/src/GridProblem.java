/**
 * Created by achowdhury on 6/27/2015.
 */
/*
“Given a grid of size m by n, write an algorithm that computes all paths from 0,0 to m,n such that you can always step horizontally or vertically
but cannot reverse.”
* */
public class GridProblem {

    public int CalculatePath(int down, int right, String path){
        int maxDown = 4;
        int maxRight = 3;
        //reached the end element of the matrix no where to go
        if(down == maxDown - 1 && right == maxRight - 1){
            System.out.println(path);
            return 1;
        }
        //last row
        else if(down == maxDown - 1 ){
            int content = CalculatePath(down, right + 1 , path);
            return content;
        }
        //last col
        else if(right == maxRight - 1 ){
            int content = CalculatePath(down + 1, right, path);
            return content;
        }
        //middle row and col
        else{
            int content = CalculatePath(down, right + 1 , path) + CalculatePath(down + 1, right, path);
            return content;
        }
    }
}
