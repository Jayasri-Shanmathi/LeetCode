class Solution {
    public int maximalSquare(char[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int[][]dp=new int[r+1][c+1];
        int maxside=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]=='1'){
                    int min=Math.min(dp[i+1][j],dp[i][j+1]);
                    dp[i+1][j+1]=1+Math.min(min,dp[i][j]);
                }
                maxside=Math.max(maxside,dp[i+1][j+1]);
            }
        }
        return maxside*maxside;

    }
}