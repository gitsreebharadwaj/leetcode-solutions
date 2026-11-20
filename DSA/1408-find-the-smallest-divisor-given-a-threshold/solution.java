class Solution {
    public int sumOfDivisions(int[] nums, int divisor) {
        int sum=0;
        for(int i=0; i<nums.length; i++) {
            sum+=Math.ceil((double)nums[i]/divisor);
        }
        return sum;
    }
    public int max(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            max=Math.max(max, nums[i]);
        }
        return max;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=max(nums);
        int ans=high;
        while(low<=high) {
            int mid=(low+high)/2;
            if(sumOfDivisions(nums, mid)<=threshold) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
}
