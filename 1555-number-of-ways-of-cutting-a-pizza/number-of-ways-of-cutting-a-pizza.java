class Solution {
    int dfs(int m,int n,int k,int r,int c,Integer[][][]dp,int[][]prefix){
        if(prefix[r][c]==0) return 0;
        if(k==0)return 1;
        if(dp[k][r][c] != null) return dp[k][r][c];
        int ans=0;
        for(int h=r+1;h<m;h++){
            if(prefix[r][c]-prefix[h][c]>0)
               ans=(ans+ dfs(m,n,k-1,h,c,dp,prefix))% 1_000_000_007;
        }
        for(int v=c+1;v<n;v++){
            if(prefix[r][c]-prefix[r][v]>0)
               ans=(ans+dfs(m,n,k-1,r,v,dp,prefix))% 1_000_000_007;
        }
        return dp[k][r][c]=ans;
    }
    public int ways(String[] pizza, int k) {
        int m=pizza.length;
        int n=pizza[0].length();
        int[][]prefix=new int[m+1][n+1];
        Integer[][][]dp=new Integer[k][m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                prefix[i][j]=prefix[i][j+1]+prefix[i+1][j]-prefix[i+1][j+1]+(pizza[i].charAt(j)=='A'?1:0);
            }
        }
        return dfs(m,n,k-1,0,0,dp,prefix);
    }
}