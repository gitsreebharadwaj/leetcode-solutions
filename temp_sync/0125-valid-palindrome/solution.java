class Solution {
    public boolean isPalindrome(String s) {
        String clean=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len=clean.length();
        int l=0;
        int r=len-1;
        while(l<r) {
            if(clean.charAt(l)==clean.charAt(r)) {
                l++;
                r--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
