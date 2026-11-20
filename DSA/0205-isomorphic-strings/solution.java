class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        Map<Character, Character> mapstot=new HashMap<>();
        Map<Character, Character> mapttos=new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(mapstot.containsKey(c1) && mapstot.get(c1)!=c2) {
                return false;
            }
            if(mapttos.containsKey(c2) && mapttos.get(c2)!=c1) {
                return false;
            }
            mapstot.put(c1, c2);
            mapttos.put(c2, c1);
        }
        return true;
    }
}
