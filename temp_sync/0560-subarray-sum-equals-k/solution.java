class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int i=0; i<nums.length; i++) {
            int ssum=0;
            for(int j=i; j<nums.length; j++) {
                ssum+=nums[j];
                if(ssum==k) {
                    count++;
                }
            }
        }
        return count;
    }
}
