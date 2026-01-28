class Solution {
    public int characterReplacement(String s, int k) {
        int[]freq=new int[26];
        int l=0;
        int maxfreq=0;int maxlen=0;
        for(int i=0;i<s.length();i++){
            int ind=s.charAt(i)-'A';
            freq[ind]++;
            maxfreq=Math.max(maxfreq,freq[ind]);
            while((i-l+1)-maxfreq>k){
                freq[s.charAt(l)-'A']--;l++;
            }
            maxlen=Math.max(maxlen,i-l+1);
        }
        return maxlen;
    }
}