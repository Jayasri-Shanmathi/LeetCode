class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;int max=0;
        for(int p:piles){
            max=Math.max(max,p);
        }
        while(min<=max){
            int mid=(min+max)/2;
            long hrs=0;
            for(int p:piles){
                hrs+=(p+mid-1)/mid;
            }
            if(hrs<=h) max=mid-1;
            else min=mid+1;
        }
        return min;
        
    }
}