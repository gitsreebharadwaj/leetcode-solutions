class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0)
        {
            return false;
        }
        int i=n;
        if(i%4==0)
        {
            while(i%4==0)
            {
                i=i/4;
            }
        }
        if(i==1)
        return true;
        else
        return false;
    }
}
