class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n<3)return 0;
        int count=0;
        for(int last=n-1;last>=2;last--){
            int left=0;int right=last-1;
            while(left<right){
            if(nums[left]+nums[right]>nums[last]){
                count+=(right-left);
                right--;
            }
            else left++;
        }
        }
      
        return count;
        }
       
    }
