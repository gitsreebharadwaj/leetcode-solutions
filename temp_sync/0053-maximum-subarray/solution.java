class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int cfs=0;
        for(int i=0; i<nums.length; i++) {
            cfs+=nums[i];
            if(cfs>max) {
                max=cfs;
            }
            if(cfs<0) {
                cfs=0;
            }
        }
        return max;
    }
}
