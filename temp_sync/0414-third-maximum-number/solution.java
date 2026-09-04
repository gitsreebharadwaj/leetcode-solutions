class Solution {
    public int thirdMax(int[] nums) {
        int n=nums.length;
        long max3=Long.MIN_VALUE;
        long max2=Long.MIN_VALUE;
        long max=Long.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(nums[i]>max) {
                max3=max2;
                max2=max;
                max=nums[i];
            }
            else if(nums[i]>max2 && nums[i]<max) {
                max3=max2;
                max2=nums[i];
            }
            else if(nums[i]>max3 && nums[i]<max2) {
                max3=nums[i];
            }
        }
        if(max3==Long.MIN_VALUE) {
            return (int)max;
        }
        return (int)max3;
    }
}
