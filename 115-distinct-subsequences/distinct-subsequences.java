class Solution {
    public int numDistinct(String s, String t) {
        int T=t.length();int S=s.length();
        int[][]dp=new int[T+1][S+1];
        for(int j=0;j<=S;j++){
            dp[0][j]=1;
        }
        for(int i=0;i<T;i++){
            for(int j=0;j<S;j++){
                if(t.charAt(i)==s.charAt(j)){
                    dp[i+1][j+1]=dp[i+1][j]+dp[i][j];
                }
                else dp[i+1][j+1]=dp[i+1][j];
            }
        }
        return dp[T][S];
    }
}