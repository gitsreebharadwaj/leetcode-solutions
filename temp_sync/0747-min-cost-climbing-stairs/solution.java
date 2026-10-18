class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return solve(cost, n, dp);
    }
    private int solve(int[] arr, int idx, int[] dp) {
        if(idx==0 || idx==1) {
            return 0;
        }
        if(dp[idx]!=-1) {
            return dp[idx];
        }
        int step1=arr[idx-1]+solve(arr, idx-1, dp);
        int step2=arr[idx-2]+solve(arr, idx-2, dp);
        return dp[idx]=Math.min(step1, step2);
    }
}
