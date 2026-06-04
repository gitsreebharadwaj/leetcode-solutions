class Solution {
    public boolean isPalindrome(String s) {
        String cleaned=s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        if(palindrome(0, cleaned)) {
            return true;
        }
        return false;
    }
    public boolean palindrome(int i, String s) {
        if(i>=s.length()/2) {
            return true;
        }
        if(s.charAt(i) != s.charAt(s.length()-i-1)) {
            return false;
        }
        return palindrome(i+1, s);
    }
}
