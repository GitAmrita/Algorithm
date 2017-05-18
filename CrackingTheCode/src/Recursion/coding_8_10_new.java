package Recursion;

/**
 * Created by amritachowdhury on 5/6/17.
 */
public class coding_8_10_new {
    int maxRow = 3;
    int maxCol = 3;
    char screen[][] = new char[maxRow][maxCol];

    public void fillColor() {
        drawScreen();
        System.out.println("******* ORIGINAL COLOR ******");
        printScreen();
        fillColor(0, 2);
        System.out.println("******* CHANGED COLOR ******");
        printScreen();
    }

    private void fillColor(int row, int col) {
        if (row < 0 || col < 0 || row > maxRow - 1 || col > maxCol - 1 || screen[row][col] != 'B') {
            return;
        }
        screen[row][col] = 'R';
        fillColor(row, col + 1);
        fillColor(row, col - 1);
        fillColor(row + 1, col);
        fillColor(row - 1, col);
    }

    private void drawScreen() {
        screen[0][0] = 'W';
        screen[0][1] = 'W';
        screen[0][2] = 'B';
        screen[1][0] = 'W';
        screen[1][1] = 'W';
        screen[1][2] = 'W';
        screen[2][0] = 'B';
        screen[2][1] = 'W';
        screen[2][2] = 'W';
    }

    private void printScreen() {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                System.out.print(screen[row][col] + " ");
            }
            System.out.println();
        }
    }
}
