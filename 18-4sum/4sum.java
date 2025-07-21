class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);int i,j;
        List<List<Integer>> lst=new ArrayList<>();
        for(i=0;i<n;i++){
          if(i>0 && nums[i]==nums[i-1]) {continue;}
          j=i+1;
          while(j<n){
            int p=j+1;
            int q=n-1;
            while(p<q){
                long sum=(long)nums[i]+(long)nums[j]+(long)nums[p]+(long)nums[q];
                if(sum>target)q--;
                else if(sum<target)p++;
                else{
                    lst.add(Arrays.asList(nums[i],nums[j],nums[p],nums[q]));
                    p++;
                    while(p<q && nums[p]==nums[p-1])p++;
                }
            }
            j++;
            while(j<n&& nums[j]==nums[j-1]) j++;
            }
        }
        return lst;
    }  
}
