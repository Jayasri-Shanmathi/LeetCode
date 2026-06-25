class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;int buy=prices[0];
        for(int i:prices){
            if(i<buy){
                buy=i;
            }
            else if(profit<i-buy){
                profit=i-buy;
            }
        }
        return profit;
    }
}