class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int cfp=1;
        int r=0;
        while(r<n) {
            cfp*=nums[r];
            if(cfp>max1) {
                max1=cfp;
            }
            if(nums[r]==0) {
                cfp=1;
            }
            r++;
        }
        r=n-1;
        cfp=1;
        while(r>=0) {
            cfp*=nums[r];
            if(cfp>max2) {
                max2=cfp;
            }
            if(nums[r]==0) {
                cfp=1;
            }
            r--;
        }
        return Math.max(max1, max2);
    }
}
