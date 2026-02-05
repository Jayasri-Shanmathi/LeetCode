class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[]result=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0) result[i]=nums[i];
            else if(nums[i]>0){
                result[i]=nums[(i+nums[i])%n];
            }
            else{
                int ind=(i+nums[i])+n;
                result[i]=nums[((i - Math.abs(nums[i])) % n + n) % n];
            }
        }
        return result;
    }
}