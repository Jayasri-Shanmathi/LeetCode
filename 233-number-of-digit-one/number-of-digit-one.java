class Solution {
    public int countDigitOne(int n) {
        int count=0;int num=1;
        while(num<=n){
            int low=n%num;
            int curr=(n/num)%10;
            int high=n/(num*10);
            if(curr==0) count+=high*num;
            else if(curr==1) count+=high*num+(low+1);
            else count+=(high+1)*num;
            num*=10;
        }
        return count;
    }
}