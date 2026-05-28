class Solution {
    public int[] runningSum(int[] nums) {
        int len=nums.length;
        int[] prefix=new int[len];
        prefix[0]=nums[0];
        for(int i=1; i<len; i++) {
            prefix[i]=prefix[i-1]+nums[i];
        }
        return prefix;
    }
}
