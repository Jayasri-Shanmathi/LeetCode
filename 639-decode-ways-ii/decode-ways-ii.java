class Solution {
    public int numDecodings(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        char first = s.charAt(0);
        if (first == '0') return 0;
        dp[1] = (first == '*') ? 9 : 1;
        for (int i = 2; i <= n; i++) {
            char c1 = s.charAt(i - 1);
            char c2 = s.charAt(i - 2);
            if (c1 == '*')
                dp[i] += 9 * dp[i - 1];
            else if (c1 != '0')
                dp[i] += dp[i - 1];
            if (c2 == '1') {
                if (c1 == '*') dp[i] += 9 * dp[i - 2];
                else dp[i] += dp[i - 2];
            }
            else if (c2 == '2') {
                if (c1 == '*') dp[i] += 6 * dp[i - 2];
                else if (c1 <= '6') dp[i] += dp[i - 2];
            }
            else if (c2 == '*') {
                if (c1 == '*') dp[i] += 15 * dp[i - 2];
                else if (c1 <= '6') dp[i] += 2 * dp[i - 2];
                else dp[i] += dp[i - 2];
            }

            dp[i] %= MOD;
        }

        return (int) dp[n];
    }
}

    