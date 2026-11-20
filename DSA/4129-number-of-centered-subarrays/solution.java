class Solution {
    public int centeredSubarrays(int[] nums) {
        int n=nums.length;
        int result=0;
        for(int i=0; i<n; i++) {
            int sum=0;
            Map<Integer, Integer> freq=new HashMap<>();
            for(int j=i; j<n; j++) {
                sum+=nums[j];
                freq.put(nums[j], freq.getOrDefault(nums[j],0)+1);
                if(freq.containsKey(sum)) {
                    result++;
                }
            }
        }
        return result;
    }
}
