class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(prices, 1, 0, n, dp);
    }
    private int solve(int[] prices, int buy, int idx, int n, int[][] dp) {
        if(idx==n) {
            return 0;
        }
        if(dp[idx][buy]!=-1) {
            return dp[idx][buy];
        }
        int profit=0;
        if(buy==1) {
            profit=Math.max(-prices[idx]+solve(prices, 0, idx+1, n, dp), 0+solve(prices, 1, idx+1, n, dp));
        }
        else {
            profit=Math.max(prices[idx]+solve(prices, 1, idx+1, n, dp), 0+solve(prices, 0, idx+1, n, dp));
        }
        return dp[idx][buy]=profit;
    }
}
