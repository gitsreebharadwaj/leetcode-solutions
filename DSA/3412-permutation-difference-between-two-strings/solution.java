class Solution {
    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int sum=0;
        for(int i=0; i<t.length(); i++) {
            char ch=t.charAt(i);
            int indexIns=map.get(ch);
            int diff=indexIns-i;
            if(diff<0) {
                diff=-diff;
            }
            sum+=diff;
        }
        return sum;
    }
}
