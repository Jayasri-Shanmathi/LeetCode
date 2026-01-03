class Solution {
    public int mergeStones(int[] stones, int K) {
        int len = stones.length;
        if ((len - 1) % (K - 1) != 0) {
            return -1;
        }
        
        int i, j, k, l, t;
        
        int[] prefixSum = new int[len + 1];
        for (i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }
        
        int max = Integer.MAX_VALUE;
        int[][][] dp = new int[len + 1][len + 1][K + 1];
        for (i = 1; i <= len; i++) {
            for (j = 1; j <= len; j++) {
                for (k = 1; k <= K; k++) {
                    dp[i][j][k] = max;
                }
            }
        }
        
        for (i = 1; i <= len; i++) {
            dp[i][i][1] = 0;
        }

        for (l = 2; l <= len; l++) {
            for (i = 1; i <= len - l + 1; i++) {
                j = i + l - 1;
                for (k = 2; k <= K; k++) {
                    for (t = i; t < j; t++) {
                        if (dp[i][t][k - 1] == max || dp[t + 1][j][1] == max) {
                            continue;
                        }
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][t][k - 1] + dp[t + 1][j][1]);
                    }
                }
                if (dp[i][j][K] == max) {
                    continue;
                }
                dp[i][j][1] = dp[i][j][K] + prefixSum[j] - prefixSum[i - 1];   
            }
        }

        return dp[1][len][1];
    }
}