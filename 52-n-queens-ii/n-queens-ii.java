class Solution {
    public int totalNQueens(int n) {
        char[][]board=new char[n][n];
        for(char[]row:board)
            Arrays.fill(row,'.');
        return dfs(0,board);
    }
    public int dfs(int col,char[][] board) {
        if (col==board.length) return 1;
        int count=0;
        for (int row=0;row<board.length;row++) {
            boolean valid=true;
            for (int r=row,c=col;r>=0 && c>= 0;r--,c--) {
                if (board[r][c]=='Q') {
                    valid=false;
                    break;
                }
            }
            for(int c=col;c>= 0 && valid;c--) {
                if(board[row][c]=='Q') {
                    valid=false;
                    break;
                }
            }
            for(int r=row,c=col;r<board.length && c>=0 && valid;r++,c--) {
                if(board[r][c]=='Q') {
                    valid=false;
                    break;
                }
            }
            if(valid) {
                board[row][col]='Q';
                count += dfs(col+1,board);
                board[row][col]='.';
            }
        }
        return count;
    }
}
