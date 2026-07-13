class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);int idx=1;
        for(int i=0;i<nums.length;i++){
           if(nums[i]<=0) continue;
           if(nums[i]>idx) return idx;
           if(nums[i]<idx) continue;
           idx++;
        }
        return idx;
    }
}