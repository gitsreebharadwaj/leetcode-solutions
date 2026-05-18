class Solution {
    public int maxSubArray(int[] nums) {
        int cfs=nums[0];
        int max=nums[0];
        for(int i=1; i<nums.length; i++) {
            cfs=Math.max(cfs+nums[i], nums[i]);
            max=Math.max(cfs, max);
        }
        return max;
    }
}
