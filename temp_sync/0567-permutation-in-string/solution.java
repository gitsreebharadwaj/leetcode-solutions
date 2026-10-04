class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) {
            return false;
        }
        int[] freq1=new int[26];
        for(int i=0; i<s1.length(); i++) {
            freq1[s1.charAt(i)-'a']++;
        }
        int[] freq2=new int[26];
        int l=0;
        int r=0;
        while(r<s2.length()) {
            char rch=s2.charAt(r);
            freq2[rch-'a']++;
            if((r-l+1)>s1.length()) {
                char lch=s2.charAt(l);
                freq2[lch-'a']--;
                l++;
            }
            if((r-l+1)==s1.length()) {
                if(match(freq1, freq2)) {
                    return true;
                }
            }
            r++;
        }
        return false;
    }
    private boolean match(int[] freq1, int[] freq2) {
        for(int i=0; i<26; i++) {
            if(freq1[i]!=freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
