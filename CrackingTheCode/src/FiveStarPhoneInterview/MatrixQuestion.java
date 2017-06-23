package FiveStarPhoneInterview;

import java.util.Random;

/**
 * Created by amritachowdhury on 6/6/17.
 */
public class MatrixQuestion {

    public static void main(String[] args) {
        MatrixQuestion r = new MatrixQuestion();
        int [][] matrix = r.generateMatrix(3, 3);
        System.out.println("Your input matrix ");
        r.printMatrix(matrix);
        matrix = r.getOutputMatrix(matrix);
        System.out.println("Your output matrix ");
        r.printMatrix(matrix);

    }

    public int [][] getOutputMatrix(int [][] matrix) {
        matrix = zeroMatrix(matrix);
        return matrix;
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
                matrix = MakeRowZero(matrix, row);
            }
        }

        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                matrix = MakeColZero(matrix, col);
            }
        }

        if (hasFirstRowZero) {
            matrix = MakeRowZero(matrix, 0);
        }

        if (hasFirstColZero) {
            matrix = MakeColZero(matrix, 0);
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

    private int[][] MakeRowZero(int[][]matrix, int row) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
        return matrix;
    }

    private int[][] MakeColZero(int[][]matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
        return matrix;
    }

    public void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col ++) {
                System.out.print(matrix[row][col] + "  ");
            }
            System.out.println();
        }
    }

    // for generating the test cases. I used a random number generator to build the matrix.
    public int[][] generateMatrix(int rowCount, int colCount) {
        int[][] matrix = new int[rowCount][colCount];
        Random rand = new Random();
        for (int row = 0; row < rowCount; row ++) {
            for (int col = 0; col < colCount; col ++) {
                matrix[row][col] = generateRandom(0, 8, rand); // the min and max are just randomly chosen. No logic here.
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
