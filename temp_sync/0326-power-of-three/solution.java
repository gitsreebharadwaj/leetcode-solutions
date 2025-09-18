class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0)
        {
            return false;
        }
        int i=n;
        if(i%3==0)
        {
            while(i%3==0)
            {
                i=i/3;
            }
        }
        if(i==1)
        return true;
        else
        return false;
    }
}
