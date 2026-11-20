class Solution {
    public long minCost(String s, int[] cost) {
        long totalCost=0;
        long maxKeep=0;
        Map<Character, Long> keepCost=new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            long c=cost[i];
            totalCost+=c;
            long updated=keepCost.getOrDefault(ch, 0L)+c;
            keepCost.put(ch, updated);
            if(updated>maxKeep) {
                maxKeep=updated;
            }
        }
        return totalCost-maxKeep;
    }
}
