class Solution {
    public long putMarbles(int[] weights, int k) {
        int N=weights.length;
        long[]sum=new long[N-1];
        for(int i=0;i<N-1;i++){
            sum[i]=weights[i]+weights[i+1];
        }
        Arrays.sort(sum);
        long min=0;long max=0;
        for(int i=0;i<k-1;i++){
            min+=sum[i];
        }
        int n=sum.length;
        for(int i=n-1;i>n-k;i--){
            max+=sum[i];
        }
        return max-min;
    }
}