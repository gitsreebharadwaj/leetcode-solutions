class Solution {
    public int characterReplacement(String s, int k) {
         int[] freq = new int[26];
        int l = 0, r = 0;
        int maxF = 0;
        int maxLength = 0;
        while (r < s.length()) {
            freq[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, freq[s.charAt(r) - 'A']);
            if((r - l + 1) - maxF > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}
