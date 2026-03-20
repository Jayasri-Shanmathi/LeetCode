class Solution {
    public int bitwiseComplement(int n) {
        if(n==0)return 1;
        int num=0;
        int bit=1;
        while(n>0){
            if((n&1)==0) num|=bit;
            n>>=1;
            bit<<=1;
        }
       return num;
    }
}