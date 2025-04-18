package DSAbyRuddarm.BackTracking;

public class Nqueen {
    static int k = 0; // Counter for the number of solutions

    public static void main(String[] args) {
        
        int n = 5; // Size of the chessboard
        char[][] board = new char[n][n]; // Initialize the chessboard
        solveNQueens(board, 0); // Start solving from the first row
    }

    public static void solveNQueens(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (Safe(board, row, i)) {
                board[row][i] = 'Q'; // Place the queen
                solveNQueens(board, row + 1); // Recur to place the next queen
                board[row][i] = '.'; // Backtrack
            }
        }

    }

    public static void printBoard(char[][] board) {
        System.out.println("------Chess Board is : " + ++k + "------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Q') {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean Safe(char board[][], int row, int col) {
        // vertical check
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left diagonal check
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right diagonal check
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}