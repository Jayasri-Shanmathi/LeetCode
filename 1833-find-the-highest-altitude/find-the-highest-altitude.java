class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int n=0;
        for(int i:gain){
            n=n+i;
            max=Math.max(n,max);
        }
        return max;
    }
}