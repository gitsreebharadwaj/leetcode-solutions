class Solution {
    public int tribonacci(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
    public int solve(int num, int[] dp) {
        if(num==0) {
            return 0;
        }
        if(num==1 || num==2) {
            return 1;
        }
        if(dp[num]!=-1) {
            return dp[num];
        }
        int x=solve(num-1, dp);
        int y=solve(num-2, dp);
        int z=solve(num-3, dp);
        return dp[num]=x+y+z;
    }
}
