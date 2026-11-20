class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> seen=new HashSet<>();
        int n=nums.length;
        int idx=n;
        for(int i=n-1; i>=0; i--) {
            if(seen.contains(nums[i])) {
                break;
            }
            seen.add(nums[i]);
            idx=i;
        }
        return(idx+2)/3;
    }
}
