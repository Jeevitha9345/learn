public class NQueens {

    int n;
    int[][] board;

    public NQueens(int n) {
        this.n = n;
        board = new int[n][n];
    }

    public void solve() {
        if (placeQueen(0)) {
            printBoard();
        } else {
            System.out.println("No solution exists");
        }
    }

    // Try to place queen column by column
    private boolean placeQueen(int col) {
        if (col >= n)
            return true;

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;

                if (placeQueen(col + 1))
                    return true;

                board[row][col] = 0; // backtrack
            }
        }
        return false;
    }

    // Check safety
    private boolean isSafe(int row, int col) {

        // Check left side row
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Lower diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private void printBoard() {
        System.out.println("\nSolution:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}