class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int cnt=0;
        for(int i=0; i<n; i++) {
            int v=map.getOrDefault(nums[i], 0);
            map.remove(nums[i]);
            int goodPairs=v*(v-1)/2;
            cnt+=goodPairs;
        }
        return cnt;
    }
}
