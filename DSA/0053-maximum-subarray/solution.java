class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int cfs=0;
        int max=Integer.MIN_VALUE;
        int i=0;
        int start=0;
        int bestStart=0;
        int bestEnd=0;
        while(i<n) {
            if(cfs==0) {
                start=i;
            }
            cfs+=nums[i];
            if(cfs>max) {
                bestStart=start;
                max=cfs;
                bestEnd=i;
            }
            if(cfs<0) {
                cfs=0;
            }
            i++;
        }
        return max;
    }
}
