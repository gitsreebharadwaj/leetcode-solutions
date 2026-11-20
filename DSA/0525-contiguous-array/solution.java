class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, -1);
        int preSum=0;
        int maxLen=0;
        for(int i=0; i<n; i++) {
            if(nums[i]==0) {
                preSum-=1;
            }
            else {
                preSum+=nums[i];
            }
            int rem=preSum;
            if(map.containsKey(rem)) {
                maxLen=Math.max(maxLen, i-map.get(rem));
            }
            else {
                map.put(preSum, i);
            }
        }
        return maxLen;
    }
}
