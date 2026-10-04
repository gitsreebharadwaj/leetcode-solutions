class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[256];
        for(int i=0; i<t.length(); i++) {
            freq[t.charAt(i)]++;
        }
        int n=s.length();
        int l=0;
        int r=0;
        int cnt=0;
        int sIdx=-1;
        int minLen=Integer.MAX_VALUE;
        while(r<n) {
            char rch=s.charAt(r);
            if(freq[rch]>0) {
                cnt++;
            }
            freq[rch]--;
            while(cnt==t.length()) {
                if(r-l+1<minLen) {
                    minLen=r-l+1;
                    sIdx=l;
                }
                char lch=s.charAt(l);
                freq[lch]++;
                if(freq[lch]>0) {
                    cnt--;
                }
                l++;
            }
            r++;
        }
        if(sIdx==-1) return "";
        return s.substring(sIdx, sIdx+minLen);
    }
}
