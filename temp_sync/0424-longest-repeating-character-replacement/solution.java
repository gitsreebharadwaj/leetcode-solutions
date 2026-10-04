class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int n=s.length();
        int l=0;
        int r=0;
        int maxFreq=0;
        int maxLen=0;
        while(r<n) {
            char rch=s.charAt(r);
            freq[rch-'A']++;
            maxFreq=Math.max(maxFreq, freq[rch-'A']);
            if((r-l+1)-maxFreq>k) {
                char lch=s.charAt(l);
                freq[lch-'A']--;
                l++;
            }
            if((r-l+1)-maxFreq<=k) {
                int len=(r-l+1);
                maxLen=Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }
}
