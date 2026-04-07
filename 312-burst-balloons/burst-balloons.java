class Solution {
    private int burst(int left,int right,int[]nums,Integer[][]dp){
        //if(left==right)return nums[left];
        if(left>right)return 0;
        if(dp[left][right]!=null) return dp[left][right];
        int max=0;int l;int r;
        for(int i=left;i<=right;i++){
            if(left==0)l=1;
            else l=nums[left-1];
            if(right==nums.length-1)r=1;
            else r=nums[right+1];
            int coin=burst(left,i-1,nums,dp)+l*nums[i]*r+burst(i+1,right,nums,dp);
            max=Math.max(max,coin);
        }
        dp[left][right]=max;
        return max;
    }
    public int maxCoins(int[] nums) {
        int N=nums.length;
        Integer[][]dp=new Integer[N][N];
        int ans=0;
        return burst(0,N-1,nums,dp);
    }
}