class Solution {
    public int fib(int n) {
        if(n<=1) {
            return n;
        }
        int flast=fib(n-1);
        int slast=fib(n-2);
        return flast+slast;
    }
}
