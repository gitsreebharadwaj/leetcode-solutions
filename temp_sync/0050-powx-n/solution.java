class Solution {
    public double myPow(double x, int n) {
        if(n<0) {
            return 1.0/power(x,Math.abs(n));
        }
        return power(x,n);
    }
    public double power(double x, int n) {
        if(x==0) {
            return 0;
        }
        if(n==0) {
            return 1;
        }
        if(x==1) {
            return 1;
        }
        if(n==1) {
            return x;
        }
        if(n%2==0) {
            return power(x*x, n/2);
        }
        else {
            return x*power(x*x, n/2);
        }
    }
}
