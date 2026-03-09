class Solution {
    static int mod=1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][]dp1=new int[zero+1][one+1];
        int[][]dp2=new int[zero+1][one+1];
        for(int i=1;i<=Math.min(zero,limit);++i){
            dp1[i][0]=1;
        }
        for(int i=1;i<=Math.min(one,limit);++i){
            dp2[0][i]=1;
        }
        for(int i=1;i<=zero;++i){
            for(int j=1;j<=one;++j){
                for(int k=1;k<=Math.min(limit,i);++k){
                    dp1[i][j]=(dp1[i][j]+dp2[i-k][j])%mod;
                }
                for(int k=1;k<=Math.min(limit,j);++k){
                    dp2[i][j]=(dp2[i][j]+dp1[i][j-k])%mod;
                }
            }
        }
        return (dp1[zero][one]+dp2[zero][one])%mod;
    }
}