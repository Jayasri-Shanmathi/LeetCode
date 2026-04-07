class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N=nums.length;
        Arrays.sort(nums);
        int target=0;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<N-2;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int j=i+1;
            int k=N-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target){
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);l.add(nums[j]);l.add(nums[k]);
                    ans.add(l);
                    j++;k--;
                    while(j<k && nums[j]==nums[j-1])j++;
                    while(j<k && nums[k]==nums[k+1])k--;
                }
                else if(sum>target) k--;
                else j++;
                
            }
        }
        return ans;
    }
}