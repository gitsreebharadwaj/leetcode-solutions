class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen=new int[3];
        int cnt=0;
        Arrays.fill(lastSeen, -1);
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            lastSeen[ch-'a']=i;
            cnt+=1+Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
        }
        return cnt;
    }
}
