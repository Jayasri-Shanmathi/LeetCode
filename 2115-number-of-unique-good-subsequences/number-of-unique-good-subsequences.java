class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int eone=0;int ezero=0;int zero=0;
        int mod=1_000_000_007;
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1'){
                eone=(eone+ezero+1)%mod;
            }
            else{
                zero=1;
                ezero=(ezero+eone)%mod;
            }
        } 
        return ((ezero+eone+zero)%mod);
    }
}