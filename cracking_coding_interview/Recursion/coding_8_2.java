package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amritachowdhury on 4/29/17.
 */
public class coding_8_2 {
    Map<Integer, Integer> restriction = new HashMap<>();
    int maxRow = 3;
    int maxCol = 3;
    List<String> paths = new ArrayList<>();

    public void maze() {
        restriction.put(0, 2);
        restriction.put(1, 1);
        go(0, 0);
    }

    private void  go( int row, int col) {
        if (row == maxRow || col == maxCol || isRestricted(row, col)) {
            return;
        }
        String path = "(" + String.valueOf(row) + ", " + String.valueOf(col) + ")-> ";
        paths.add(path);
        go (row, col + 1);
        go (row + 1, col);
        if (row == maxRow - 1 && col == maxCol - 1) {
            printPath(paths);
            paths.clear();
        }

    }

    private boolean isRestricted(int row, int col) {
        Integer restrictedCol = restriction.get(row);
        if (restrictedCol == null) {
            return false;
        }
        return  restrictedCol == col;
    }

    private void printPath(List<String> path) {
        String terminal = path.get(path.size() - 1);
        if (terminal.equals("(2, 2)-> ")) {
            for (String s : path) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
