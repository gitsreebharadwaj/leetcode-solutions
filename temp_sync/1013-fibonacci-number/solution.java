class Solution {
    public int fib(int n) {
        if (n<2) 
        {
            return n;
        }
        else
        {
            int f0 = 0, f1 = 1;
            for (int i = 2; i <= n; i++) 
            {
                int fn=f0+f1;
                f0=f1;
                f1=fn;
            }
            return f1;
        }
    }
}
