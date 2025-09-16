class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<0)
        {
            return false;
        }
        if(n==1)
        {
            return true;
        }
        int i=n;
        if(i%2!=0)
        {
            return false;
        }
        else
        {
            while(i!=0)
            {
                i=i/2;
                if(i%2!=0)
                break;
                else
                continue;
            }
        }
        if(i==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
