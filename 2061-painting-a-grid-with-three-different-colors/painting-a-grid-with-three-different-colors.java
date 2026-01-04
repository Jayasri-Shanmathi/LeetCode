class Solution {
    static int mod=1_000_000_007;
    public int colorTheGrid(int m, int n) {
        int totalCom=1;
        for(int i=0;i<m;i++)totalCom*=3;
        int[][]dp=new int[n+1][totalCom];
        int[][]validR=new int[totalCom][totalCom];
        List<Integer> valid=new ArrayList<>();
        List<Integer>[] combination=new ArrayList[totalCom];
        for(int i=0;i<totalCom;i++) combination[i]=new ArrayList<>();
        for(int i=0;i<totalCom;i++){
            int val=i;boolean flag=true;
            for(int j=0;j<m;j++){
                combination[i].add(val%3);
                val/=3;
            }
            for(int j=1;j<m;j++){
                if(combination[i].get(j).equals(combination[i].get(j-1)))
                       { flag=false;break;}
            }
            if(flag) valid.add(i);
        }
        for(int c:valid){
            dp[1][c]=1;
        }
        for(int c1:valid){
            for(int c2:valid){
                validR[c1][c2]=1;
                for(int c=0;c<m;c++){
                    if(combination[c1].get(c).equals(combination[c2].get(c)))
                    validR[c1][c2]=0;
                }
            }
        }
        for(int i=2;i<=n;i++){
            for(int j:valid){
                long sum=0;
                for(int k:valid){
                    if(validR[j][k]==1)sum+=dp[i-1][k];
                }
                dp[i][j]=(int)(sum%mod);
            }
        }
        long res=0;
        for(int i=0;i<totalCom;i++){
            res+=dp[n][i];
        }
        return (int)(res%mod);
    }
}