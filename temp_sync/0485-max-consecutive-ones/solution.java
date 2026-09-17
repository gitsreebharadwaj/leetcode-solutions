class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int max=0;
        int len=0;
        int i=0;
        while(i<n) {
            if(nums[i]==1) {
                len++;
                max=Math.max(max, len);
                i++;
            }
            else {
                len=0;
                i++;
            }
        }
        return max;
    }
}
