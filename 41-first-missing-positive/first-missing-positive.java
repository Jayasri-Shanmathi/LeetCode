class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        int max=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0) continue;
            set.add(nums[i]);
            max=Math.max(max,nums[i]);
        }
        for(int i=1;i<n+1;i++){
            if(!set.contains(i))
                 {
                    return i;
                 }
        }
        return max+1;
    }   
    
}
        