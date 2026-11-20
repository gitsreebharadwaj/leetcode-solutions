class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int min=Integer.MAX_VALUE;
        while(low<=high) {
            if(nums[low]<=nums[high]) {
                return nums[low];
            }
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[mid]) {
                min=nums[low];
                low=mid+1;
            }
            else {
                high=mid;
            }
        }
        return min;
    }
}
