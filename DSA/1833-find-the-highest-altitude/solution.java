class Solution {
    public int largestAltitude(int[] gain) {
        int maxAlt=0;
        int alt=0;
        for(int num : gain) {
            alt+=num;
            maxAlt=Math.max(maxAlt, alt);
        }
        return maxAlt;
    }
}
