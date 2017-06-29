package SortingAndSearching;

/**
 * Created by amritachowdhury on 6/29/17.
 */
public class coding_10_9 {
    int[][] matrix = new int[4][4];

    public void run() {
        populateMatrix();
        int target = 55;
        String result = findTargetIndex(target);
        System.out.println(result);
    }

    private String findTargetIndex(int target) {
        int row = 0; int col = matrix[0].length - 1;
        while (row <= matrix.length - 1 && col >= 0) {
            if (matrix[row][col] == target) {
                return "Row : " + row + " and col : " + col;
            } else if (matrix[row][col] > target) {
                col --;
            } else {
                row ++;
            }
        }
        return "target not found";
    }

    private void populateMatrix() {
        matrix[0][0] = 15; matrix[0][1] = 20; matrix[0][2] = 40; matrix[0][3] = 85;
        matrix[1][0] = 20; matrix[1][1] = 35; matrix[1][2] = 80; matrix[1][3] = 95;
        matrix[2][0] = 30; matrix[2][1] = 55; matrix[2][2] = 95; matrix[2][3] = 105;
        matrix[3][0] = 40; matrix[3][1] = 80; matrix[3][2] = 100; matrix[3][3] = 120;
    }
}
