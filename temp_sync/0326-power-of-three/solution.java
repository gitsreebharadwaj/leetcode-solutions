class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<0)
        {
            return false;
        }
        if(n==1)
        {
            return true;
        }
        if(n%2==1 && n%3!=0)
        {
            return false;
        }
        int i=n;
        if(i%2==0)
        {
            return false;
        }
        else
        {
            while(i!=0)
            {
                i=i/3;
                if(i%2==0)
                break;
                else if(i%3!=0)
                break;
                else
                continue;
            }
        }
        if(i==1)
        return true;
        else
        return false;
    }
}
