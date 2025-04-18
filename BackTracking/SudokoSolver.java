package DSAbyRuddarm.BackTracking;
public class SudokoSolver {
    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 2, 8, 0, 0},
            {0, 0, 0, 4, 1, 9, 0, 0 ,5},
            {0, 2, 4, 6, 8, 5, 7, 9, 3}
        };
        
        if (!solveSudoku(board, 0, 0)) {
            System.out.println("No solution exists");
        } else {
            printBoard(board);
        }
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveSudoku(int[][] board, int row, int col) {
        if (row == 9) return true;

        int newRow = (col == 8) ? row + 1 : row;
        int newCol = (col + 1) % 9;

        if (board[row][col] != 0) {
            return solveSudoku(board, newRow, newCol);
        }

        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, newRow, newCol)) return true;
                board[row][col] = 0; // backtrack
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col , int num) {
        // check row and column
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num || board[x][col] == num) return false;
        }

        // check 3x3 grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false;
            }
        }

        return true;
    }
}
