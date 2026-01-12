class Solution {
    public int distinctSubseqII(String s) {
        long mod=1000000007L;
        int n=s.length();
        long[]dp=new long[n + 1];
        dp[0]=1;
        Map<Character, Integer> map=new HashMap<>();
        for (int i=1;i<=n;i++) {
            dp[i]=(dp[i-1] * 2) % mod;
            char c=s.charAt(i - 1);
            if (map.containsKey(c)) {
                int j=map.get(c);
                dp[i]=(dp[i]-dp[j-1]+mod)%mod;
            }
            map.put(c, i);
        }

        return (int)((dp[n]-1+mod)%mod);
    }
}