class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
        {
            return false;
        }
        int i=n;
        if(i%2==0)
        {
            while(i%2==0)
            {
                i=i/2;
            }
        }
        if(i==1)
        return true;
        else
        return false;
    }
}
