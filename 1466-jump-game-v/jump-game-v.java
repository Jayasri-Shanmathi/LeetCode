class Solution {
    private int dfs(int[]arr,int d,int i,int[]dp){
        if(dp[i]!=0)return dp[i];
        int max=1;
        for(int j=i-1;j>=Math.max(0,i-d);j--){
            if(arr[j]>=arr[i])break;
            max=Math.max(max,1+dfs(arr,d,j,dp));
        }
        for(int j=i+1;j<=Math.min(arr.length-1,i+d);j++){
            if(arr[j]>=arr[i])break;
            max=Math.max(max,1+dfs(arr,d,j,dp));
        }     
        return dp[i]=max;   
    }
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int[]dp=new int[n];
        int max=1;
        for(int i=0;i<n;i++){
            max=Math.max(max,dfs(arr,d,i,dp));
        }
        return max;        
    }
}