class Solution {
    public int minCut(String s) {
        int n=s.length();
        boolean[][] pal=new boolean[n][n];
        for (int i=n-1;i>=0;i--) {
            for (int j=i;j<n;j++) {
                if (s.charAt(i)==s.charAt(j) && (j-i<2||pal[i+ 1][j-1])) {
                    pal[i][j]=true;
                }
            }
        }
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i=0;i<n;i++){
            if(pal[0][i]){
                dp[i]=0;
            } else {
                for(int j=1;j<=i;j++) {
                    if(pal[j][i]){
                        dp[i]=Math.min(dp[i],dp[j-1]+1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}
