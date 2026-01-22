class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0;
        for(int w:weights) {
            low=Math.max(low,w); 
            high+=w;              
        }
        while(low<=high) {
            int mid=low+(high-low)/2;
            int needDays=1;
            int curr=0;
            for(int w:weights) {
                if(curr+w<=mid) {
                    curr+=w;
                } 
                else{
                    needDays++;
                    curr=w;
                }
            }
            if(needDays<=days) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return low;
    }
}