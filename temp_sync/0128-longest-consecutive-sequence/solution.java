class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) {
            return 0;
        }
        Arrays.sort(nums);
        int longest=1;
        int cnt=0;
        int prev=Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(nums[i]-1==prev) {
                cnt++;
                prev=nums[i];
            }
            else if(nums[i]!=prev) {
                cnt=1;
                prev=nums[i];
            }
            longest=Math.max(longest, cnt);
        }
        return longest;
    }
}
