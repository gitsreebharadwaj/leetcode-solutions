class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[256];
        for(int i=0; i<t.length(); i++) {
            char ch=t.charAt(i);
            freq[ch]++;
        }
        int l=0;
        int r=0;
        int cnt=0;
        int sIdx=-1;
        int minLen=Integer.MAX_VALUE;
        while(r<s.length()) {
            char chr=s.charAt(r);
            if(freq[chr]>0) cnt++;
            freq[chr]--;
            while(cnt==t.length()) {
                if(r-l+1<minLen) {
                    minLen=r-l+1;
                    sIdx=l;
                }
                char chl=s.charAt(l);
                freq[chl]++;
                if(freq[chl]>0) {
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
