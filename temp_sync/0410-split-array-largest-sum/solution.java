class Solution {
    public int noOfArrays(int[] nums, int maxSumLimit) {
        int noOfArrays=1;
        int last=0;
        for(int i=0; i<nums.length; i++) {
            if(last+nums[i]<=maxSumLimit) {
                last+=nums[i];
            }
            else {
                noOfArrays++;
                last=nums[i];
            }
        }
        return noOfArrays;
    }
    public int max(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            max=Math.max(max, nums[i]);
        }
        return max;
    }
    public int sum(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
        }
        return sum;
    }
    public int splitArray(int[] nums, int k) {
        int low=max(nums);
        int high=sum(nums);
        while(low<=high) {
            int mid=(low+high)/2;
            int rarrays=noOfArrays(nums, mid);
            if(rarrays>k) {
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return low;
    }
}
