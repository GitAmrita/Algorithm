package ArrayAndString;

import java.util.Random;

/**
 * Created by amritachowdhury on 5/27/17.
 */
public class coding_1_8 {

    public void run() {
        int [][] matrix = buildMatrix(3, 5);
        printMatrix(matrix);
        matrix = zeroMatrix(matrix);
        System.out.println();
        printMatrix(matrix);
    }

    private int[][] zeroMatrix(int[][]matrix) {
        boolean hasFirstRowZero = checkFirstRowHasZero(matrix);
        boolean hasFirstColZero = checkFirstColHasZero(matrix);

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                matrix = nullifyRow(matrix, row);
            }
        }

        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                matrix = nullifyCol(matrix, col);
            }
        }

        if (hasFirstRowZero) {
            matrix = nullifyRow(matrix, 0);
        }

        if (hasFirstColZero) {
            matrix = nullifyCol(matrix, 0);
        }
        return matrix;
    }

    private boolean checkFirstRowHasZero(int[][]matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkFirstColHasZero(int[][]matrix) {
        for (int row = 0; row < matrix[0].length; row++) {
            if (matrix[row][0] == 0) {
                return true;
            }
        }
        return false;
    }

    private int[][] nullifyRow(int[][]matrix, int row) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
        return matrix;
    }

    private int[][] nullifyCol(int[][]matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
        return matrix;
    }

    private int[][] buildMatrix(int rowCount, int colCount) {
        int[][] matrix = new int[rowCount][colCount];
        Random rand = new Random();
        for (int row = 0; row < rowCount; row ++) {
            for (int col = 0; col < colCount; col ++) {
                matrix[row][col] = generateRandom(0, 4, rand);
            }
            System.out.println();
        }
        return matrix;
    }

    private int generateRandom(int min, int max, Random rand) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    private void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col ++) {
                System.out.print(matrix[row][col] + "  ");
            }
            System.out.println();
        }
    }
}
