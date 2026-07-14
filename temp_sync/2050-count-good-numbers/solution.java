class Solution {
    private static final int MOD=1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenIndices=(n+1)/2;
        long oddIndices=n/2;
        long even=solve(5, evenIndices);
        long odd=solve(4, oddIndices);
        return (int)((even*odd)%MOD);
    }
    public long solve(long base, long power) {
        if(power==0) {
            return 1;
        }
        if(power%2==0) {
            return solve((base*base)%MOD, power/2);
        }
        return (base*solve(base, power-1))%MOD;
    }
}
