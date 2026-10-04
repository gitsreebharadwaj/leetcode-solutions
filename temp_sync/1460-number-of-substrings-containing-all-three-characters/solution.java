class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        int l=0;
        int r=0;
        int[] map=new int[3];
        while(r<n) {
            char rch=s.charAt(r);
            map[rch-'a']++;
            while(map[0]>0 && map[1]>0 && map[2]>0) {
                cnt+=n-r;
                char lch=s.charAt(l);
                map[lch-'a']--;
                l++;
            }
            r++;
        }
        return cnt;
    }
}
