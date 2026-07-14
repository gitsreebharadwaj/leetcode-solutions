class Solution {
    public double myPow(double x, int n) {
        if(n==0) {
            return 1.0;
        }
        long pow=n;
        if(pow<0) {
            x=1/x;
            pow=-pow;
        }
        return solve(x, pow);
    }
    public double solve(double x, long pow) {
        if(pow==0) {
            return 1.0;
        }
        if(pow%2==0) {
            return solve(x*x, pow/2);
        }
        return x*solve(x, pow-1);
    }
}
