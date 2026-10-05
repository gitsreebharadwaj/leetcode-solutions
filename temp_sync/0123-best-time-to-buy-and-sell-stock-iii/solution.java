class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for(int i=0; i<n; i++) {
            for(int j=0; j<2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(prices, 1, 0, 2, n, dp);
    }
    private int solve(int[] prices, int buy, int idx, int cap, int n, int[][][] dp) {
        if(cap==0) {
            return 0;
        }
        if(idx==n) {
            return 0;
        }
        if(dp[idx][buy][cap]!=-1) {
            return dp[idx][buy][cap];
        }
        int profit=0;
        if(buy==1) {
            profit=Math.max(-prices[idx]+solve(prices, 0, idx+1, cap, n, dp), 0+solve(prices, 1, idx+1, cap, n, dp));
        }
        else {
            profit=Math.max(prices[idx]+solve(prices, 1, idx+1, cap-1, n, dp), 0+solve(prices, 0, idx+1, cap, n, dp));
        }
        return dp[idx][buy][cap]=profit;
    }
}
