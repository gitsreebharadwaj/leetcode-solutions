class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int preSum=0;
        int cnt=0;
        for(int i=0; i<nums.length; i++) {
            preSum+=nums[i];
            if(preSum==k) {
                cnt++;
            }
            int rem=preSum-k;
            if(map.containsKey(rem)) {
                cnt+=map.get(rem);
            }
            map.put(preSum, map.getOrDefault(preSum, 0)+1);
        }
        return cnt;
    }
}
