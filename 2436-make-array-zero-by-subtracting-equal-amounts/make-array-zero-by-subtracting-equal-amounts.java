class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            if(n==0) continue;
            set.add(n);
        }
        return set.size();    
    }
}