class Solution {
    public boolean isMatch(String s, String p) {
        int n1=s.length();int n2=p.length();
        boolean[][]dp=new boolean[n1+1][n2+1];
        dp[0][0]=true;
        for(int i=1;i<=n2;i++){
            if(p.charAt(i-1)=='*')dp[0][i]=dp[0][i-1];
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(p.charAt(j-1)=='?'|| s.charAt(i-1)==p.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*') dp[i][j]= (dp[i-1][j] || dp[i][j-1]);
            }
        }
        return dp[n1][n2];
    }
}