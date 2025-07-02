import java.util.*;
class Solution {
        public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[]pos=new int[n];
        int maxLen=1;
        Arrays.fill(pos,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                      pos[i]=Math.max(pos[i],pos[j]+1);                    
                }
            }            
        }
        for(int i=0;i<n;i++){
            if(pos[i]>maxLen)
                maxLen=pos[i];
        }
        return maxLen;
      
        
    }
}