class Solution {
      public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[][]dp=new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        return product(0,0,nums1,nums2,dp);

    }
      public int product(int i,int j,int[]nums1,int[]nums2,int[][]dp){
        if(i>=nums1.length || j>=nums2.length) return  (int)-1e9;
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        int val=Integer.MIN_VALUE;
        val=Math.max(val,nums1[i]*nums2[j]+Math.max(0,product(i+1,j+1,nums1,nums2,dp)));
        val=Math.max(val,product(i+1,j,nums1,nums2,dp));
        val=Math.max(val,product(i,j+1,nums1,nums2,dp));
        return dp[i][j]=val;
    }
}