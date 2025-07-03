class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length -1;
        int mw=0;
        while(left<right){
            int width=right-left;
            int min=Math.min(height[left],height[right]);
            mw=Math.max(mw,width*min);
            if(min==height[left])
               left++;
            else
               right--;   
        }
        return mw;
    }
}