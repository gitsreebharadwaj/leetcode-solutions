class Solution {
    public int findShortestSubArray(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        Map<Integer, Integer> firstIdx=new HashMap<>();
        Map<Integer, Integer> lastIdx=new HashMap<>();
        int maxFreq=0;
        for(int i=0; i<n; i++) {
            int num=nums[i];
            map.put(num, map.getOrDefault(num, 0)+1);
            maxFreq=Math.max(maxFreq, map.getOrDefault(num, 0));
            firstIdx.putIfAbsent(num, i);
            lastIdx.put(num, i);
        }
        int minLength=n;
        for(int key : map.keySet()) {
            if(map.get(key)==maxFreq) {
                int len=lastIdx.get(key)-firstIdx.get(key)+1;
                minLength=Math.min(minLength, len);
            }
        }
        return minLength;
    }
}
