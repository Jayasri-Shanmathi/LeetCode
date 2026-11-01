class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
        }
        int val=0;
        for(int i=0;i<nums.length;i++){
            val+=(nums[i]-min);
        }
        return val;
    }
}