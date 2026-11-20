class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        if(reverse(x)==x) {
            return true;
        }
        return false;
    }
    public int reverse(int x) {
        int rev=0;
        int rem=0;
        while(x!=0) {
            rem=x%10;
            rev=rev*10+rem;
            x/=10;
        }
        return rev;
    }
}
