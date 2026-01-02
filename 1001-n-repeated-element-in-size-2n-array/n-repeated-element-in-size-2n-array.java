class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length/2;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val=map.getOrDefault(nums[i],0);
            map.put(nums[i],++val);
        }
        for(int i=0;i<nums.length;i++){
            int v=map.get(nums[i]);
            if(v==n)return nums[i];
        }
        return 1;
    } 
}