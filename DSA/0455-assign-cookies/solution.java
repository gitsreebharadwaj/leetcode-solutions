class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n=g.length;
        int m=s.length;
        int p1=0; 
        int p2=0;
        int ans=0;
        while(p1<n && p2<m) {
            if(g[p1]<=s[p2]) {
                p1++;
            }
            p2++;
        }
        return p1;
    }
}
