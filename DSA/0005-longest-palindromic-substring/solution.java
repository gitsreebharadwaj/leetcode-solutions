class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + maxLen; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
