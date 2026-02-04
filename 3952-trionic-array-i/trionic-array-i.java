class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n<3) return false;
        int idx=1;
        while(idx<n && nums[idx] > nums[idx-1]){
            idx++;
        }
        if(idx==1 || idx==n) return false;
        while(idx<n && nums[idx]<nums[idx-1]){
            idx++;
        }
        if(idx==n) return false;
        while(idx<n && nums[idx] > nums[idx-1]){
            idx++;
        }
        if(idx==n) return true;
        else return false;
    }
}