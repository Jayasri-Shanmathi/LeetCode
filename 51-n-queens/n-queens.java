class Solution {
    public List<List<String>> solveNQueens(int n) {
         List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        // Fill board with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Start solving from row 0
        backtrack(0, board, solutions, n);
        return solutions;
    }

    // Recursive backtracking
    private void backtrack(int row, char[][] board, List<List<String>> solutions, int n) {
        if (row == n) {
            solutions.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q'; // Place queen
                backtrack(row + 1, board, solutions, n); // Recurse
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    // Check if the position is safe
    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    // Build a List<String> representation of the board
    private List<String> buildBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

   
    public static void main(String[] args) {
        Solution solver = new Solution();
        List<List<String>> result = solver.solveNQueens(4);
      
}}