class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq=new int[256];
        Arrays.fill(freq, -1);
        int l=0;
        int r=0;
        int maxLen=0;
        while(r<s.length()) {
            char ch=s.charAt(r);
            if(freq[ch]!=-1) {
                if(freq[ch]>=l) {
                    l=freq[ch]+1;
                }
            }
            int len=r-l+1;
            maxLen=Math.max(maxLen, len);
            freq[ch]=r;
            r++;
        }
        return maxLen;
    }
}
