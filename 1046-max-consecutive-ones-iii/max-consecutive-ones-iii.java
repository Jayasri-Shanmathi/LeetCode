class Solution {
    public int longestOnes(int[] nums, int k) {
        int N=nums.length;int max=0;
        int zero=0;int count=0;
        int j=0;
        for(int i=0;i<N;i++){
            if(nums[i]==0) zero++;
            while(zero>k){
                if(nums[j]==0){
                   nums[j]=1;zero--;
                }
                j++;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}