class Solution {
    public int maxSubArray(int[] nums) {
        int N=nums.length;
        int curr=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<N;i++){
            curr=Math.max(nums[i],curr+nums[i]);
            maxSum=Math.max(maxSum,curr);
        }
        return maxSum;
    }
}