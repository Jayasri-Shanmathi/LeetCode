class Solution {
    public int rob(int[] nums) {
        int[] amt= new int[nums.length];int money=0;
        if(nums.length==1) return nums[0];
        amt[0]=nums[0];
        amt[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            if(amt[i-1]<(nums[i]+amt[i-2])){
                amt[i]=nums[i]+amt[i-2];
            }
            else amt[i]=amt[i-1];
        }
        return amt[nums.length-1];
        }
}