class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        Map<Integer, Integer> map=new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int idx=0;
        while(idx<k) {
            int maxFreq=-1;
            int el=0;
            for(int key : map.keySet()) {
                int freq=map.get(key);
                if(freq>maxFreq) {
                    maxFreq=freq;
                    el=key;
                }
            }
            res[idx++]=el;
            map.put(el, -1);
        }
        return res;
    }
}
