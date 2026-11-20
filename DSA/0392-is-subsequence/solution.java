class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) {
            return true;
        }
        int l=0;
        int r=0;
        while(r<t.length()) {
            if(s.charAt(l)==t.charAt(r)) {
                l++;
                if(l==s.length()) {
                    return true;
                }
            }
            r++;
        }
        return false;
    }
}
