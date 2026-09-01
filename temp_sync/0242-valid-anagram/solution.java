class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        int n=s.length();
        int[] freq=new int[26];
        char[] schars=s.toCharArray();
        char[] tchars=t.toCharArray();
        for(int i=0; i<n; i++) {
            freq[schars[i]-'a']++;
            freq[tchars[i]-'a']--;
        }
        for(int f : freq) {
            if(f!=0) {
                return false;
            }
        }
        return true;
    }
}
