class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if(s==null || p==null || p.length()>s.length()) {
            return res;
        }
        int[] freqp=new int[26];
        for(char c : p.toCharArray()) {
            freqp[c-'a']++;
        }
        int[] freqs=new int[26];
        int l=0;
        int r=0;
        while(r<s.length()) {
            char chr=s.charAt(r);
            freqs[chr-'a']++;
            while(r-l+1>p.length()) {
                char chl=s.charAt(l);
                freqs[chl-'a']--;
                l++;
            }
            if(r-l+1==p.length()) {
                if(check(freqp, freqs)) {
                    res.add(l);
                }
            }
            r++;
        }
        return res;
    }
    public boolean check(int[] freqp, int[] freqs) {
        for(int i=0; i<26; i++) {
            if(freqp[i]!=freqs[i]) {
                return false;
            }
        }
        return true;
    } 
}
