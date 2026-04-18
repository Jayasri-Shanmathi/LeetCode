class Solution {
    public int mirrorDistance(int n) {
        int sum=0;
        int temp=n;
        while(temp>0){
            int rem=temp%10;
            sum=sum*10+rem;
            temp/=10;
        }
        return (int)Math.abs(n-sum);
    }
}