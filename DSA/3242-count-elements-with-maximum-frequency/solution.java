class Solution {
    public int maxFrequencyElements(int[] nums) {
        int ans=0;
        Map<Integer, Integer> map=new HashMap<>();
        int currFreq=0;
        int maxFreq=0;
        for(int num : nums) {
            currFreq=map.getOrDefault(num, 0)+1;
            map.put(num, currFreq);
            maxFreq=Math.max(maxFreq, currFreq);
        }
        for(int freq : map.values()) {
            if(freq==maxFreq) {
                ans+=freq;
            }
        }
        return ans;
    }
}
