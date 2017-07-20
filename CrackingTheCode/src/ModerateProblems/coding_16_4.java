package ModerateProblems;

/**
 * Created by amritachowdhury on 7/2/17.
 */
public class coding_16_4 {

    public enum PIECE
    {
        PIECE_X, PIECE_Y, EMPTY, DRAW
    }

    public void run() {
        PIECE[][] board = getTicTacToe();
        PIECE winner = computeWinner(board);
        String declareWinner = "";
        switch(winner) {
            case PIECE_X:
                declareWinner = " The winner is player X.";
                break;
            case PIECE_Y:
                declareWinner = " The winner is player Y.";
                break;
            case EMPTY:
                declareWinner = " There is no winner.";
                break;
        }

        System.out.println(declareWinner);
    }

    private PIECE computeWinner(PIECE[][] board) {
        for (int i = 0; i < board.length; i++) {
            // check all rows
            PIECE winner = hasWon(board[i][0], board[i][1], board[i][2]);
            if (winner != PIECE.EMPTY && winner != PIECE.DRAW) {
                return winner;
            }

            // check all columns
            winner = hasWon(board[0][i], board[1][i], board[2][i]);
            if (winner != PIECE.EMPTY && winner != PIECE.DRAW) {
                return winner;
            }
        }

        // check diagonal starting from 00
        PIECE winner = hasWon(board[0][0], board[1][1], board[2][1]);
        if (winner != PIECE.EMPTY && winner != PIECE.DRAW) {
            return winner;
        }

        // check diagonal starting from 02
        winner = hasWon(board[0][2], board[1][1], board[2][0]);
        return winner;
    }

    private PIECE[][] getTicTacToe() {
        PIECE[][] ticTacToe = new PIECE[3][3];
        ticTacToe[0][0] = PIECE.PIECE_X; ticTacToe[0][1] = PIECE.PIECE_X; ticTacToe[0][2] = PIECE.PIECE_X;
        ticTacToe[1][0] = PIECE.PIECE_Y; ticTacToe[1][1] = PIECE.PIECE_Y; ticTacToe[1][2] = PIECE.PIECE_X;
        ticTacToe[2][0] = PIECE.PIECE_Y; ticTacToe[2][1] = PIECE.PIECE_X; ticTacToe[2][2] = PIECE.PIECE_Y;
        return ticTacToe;
    }

    private PIECE hasWon(PIECE piece1, PIECE piece2, PIECE piece3) {
        if (piece1 == PIECE.EMPTY || piece2 == PIECE.EMPTY || piece3 == PIECE.EMPTY) {
            return PIECE.EMPTY;
        }
        else if (piece1 == piece2 && piece2 == piece3) {
            return piece1;
        } else {
            return PIECE.DRAW;
        }
    }
}
