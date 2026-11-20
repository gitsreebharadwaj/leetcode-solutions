class Solution {
    public int strStr(String haystack, String needle) {
        int l=0;
        int r=0;
        int n=haystack.length();
        int m=needle.length();
        if(needle.isEmpty()) {
            return 0;
        }
        if(m>n) {
            return -1;
        }
        while(r<n) {
            if((r-l+1)==m) {
                if(checkMatch(haystack, needle, l, r)) {
                    return l;
                }
                l++;
            }
            r++;
        }
        return -1;
    }
    public boolean checkMatch(String haystack, String needle, int start, int end) {
        int i=0;
        while(start<=end) {
            if(haystack.charAt(start)!=needle.charAt(i)) {
                return false;
            }
            start++;
            i++;
        }
        return true;
    }
}
