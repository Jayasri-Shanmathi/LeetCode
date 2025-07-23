class Solution {
    public int climbStairs(int n) {
       if(n==1 || n==2) return n;
       int[]dp=new int[n];
       dp[0]=0;dp[1]=1;dp[2]=2;
       for(int i=3;i<n;i++){
        dp[i]=dp[i-2]+dp[i-1];
       } 
       return dp[n-1]+dp[n-2];
    }
}