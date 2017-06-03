package ArrayAndString;

import java.util.Random;

/**
 * Created by amritachowdhury on 5/27/17.
 */
public class coding_1_7 {

    public void run() {
        int[][] matrix = buildMatrix(4);
        printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        printMatrix(matrix);
    }

    private boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first]; //left -> top
                matrix[last - offset][first] = matrix[last][last - offset]; //bottom -> left
                matrix[last][last - offset] = matrix[i][last]; //right -> bottom
                matrix[i][last] = top;
            }
        }
        return true;
    }

    private void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix.length; col ++) {
                System.out.print(matrix[row][col] + "  ");
            }
            System.out.println();
        }
    }

    private int[][] buildMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random rand = new Random();
        for (int row = 0; row < n; row ++) {
            for (int col = 0; col < n; col ++) {
                matrix[row][col] = generateRandom(10, 99, rand);
            }
            System.out.println();
        }
        return matrix;
    }

    private int generateRandom(int min, int max, Random rand) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
