class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countSubarraysWithOddCount(nums, k)-countSubarraysWithOddCount(nums, k-1);
    }
    public int countSubarraysWithOddCount(int[] nums, int k) {
        if(k<0) {
            return 0;
        }
        int l=0;
        int r=0;
        int oddcount=0;
        int cnt=0;
        while(r<nums.length) {
            if(nums[r]%2!=0) {
                oddcount++;
            }
            while(oddcount>k) {
                if(nums[l]%2!=0) {
                    oddcount--;
                }
                l++;
            }
            cnt=cnt+(r-l+1);
            r++;
        }
        return cnt;
    }
}
