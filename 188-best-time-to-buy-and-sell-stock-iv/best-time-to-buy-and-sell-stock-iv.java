class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][]dp=new int[k+1][n];
        for(int i=1;i<=k;i++){
            int max=dp[i-1][0]-prices[0];
            for(int j=1;j<n;j++){
                dp[i][j]=Math.max(dp[i][j-1],prices[j]+max);
                max=Math.max(max,dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][n-1];
    }
}