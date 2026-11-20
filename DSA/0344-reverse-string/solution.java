class Solution {
    public void reverseString(char[] s) {
        int l=0;
        int r=s.length-1;
        reverseRecursion(s, l, r);
    }
    public void reverseRecursion(char[] s, int l, int r) {
        if(l>=r) {
            return;
        }
        swap(s, l, r);
        reverseRecursion(s, l+1, r-1);
    }
    public void swap(char[] s, int l, int r) {
        char temp=s[l];
        s[l]=s[r];
        s[r]=temp;
    }
}
