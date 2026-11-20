class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=nums[0];
        int minSum=nums[0];
        int currmaxSum=nums[0];
        int currminSum=nums[0];
        int totalSum=nums[0];
        for(int i=1; i<nums.length; i++) {
            currmaxSum=Math.max(currmaxSum+nums[i], nums[i]);
            maxSum=Math.max(maxSum, currmaxSum);
            currminSum=Math.min(currminSum+nums[i], nums[i]);
            minSum=Math.min(minSum, currminSum);
            totalSum+=nums[i];
        }
        int circularSum=totalSum-minSum;
        if(circularSum==0) {
            return maxSum;
        }
        return Math.max(maxSum, circularSum);
    }
}
