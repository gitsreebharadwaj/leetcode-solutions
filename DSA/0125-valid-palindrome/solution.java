class Solution {
    public boolean isPalindrome(String s) {
        String corrected=s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        int l=0;
        int r=corrected.length()-1;
        while(l<r) {
            if(corrected.charAt(l)!=corrected.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
