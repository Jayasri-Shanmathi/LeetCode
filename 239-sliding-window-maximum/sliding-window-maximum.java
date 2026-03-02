class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]left=new int[nums.length];
        int[]right=new int[nums.length];
        left[0]=nums[0];right[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            if(i%k==0)left[i]=nums[i];
            else left[i]=Math.max(left[i-1],nums[i]);
        }
        for(int i=nums.length-2;i>=0;i--){
            if(i%k==0)right[i]=nums[i];
            else right[i]=Math.max(right[i+1],nums[i]);
        }
        int n=nums.length;
        int[]ans=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            ans[i]=Math.max(left[i+k-1],right[i]);
        }
        return ans;
    }
}