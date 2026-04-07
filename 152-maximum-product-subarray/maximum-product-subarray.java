class Solution {
    public int maxProduct(int[] nums) {
        int N=nums.length;
        int curr=nums[0];
        int max=nums[0];
        int p=nums[0];
        for(int i=1;i<N;i++){
            int temp=curr;
            curr=Math.max(nums[i],Math.max(curr*nums[i],p*nums[i]));
            p=Math.min(nums[i],Math.min(temp*nums[i],p*nums[i]));
            max=Math.max(max,curr);
        }
        return max;
    }
}