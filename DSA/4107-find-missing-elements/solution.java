class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        int min=min(nums);
        int max=max(nums);
        for(int num : nums) {
            set.add(num);
        }
        for(int i=min; i<=max; i++) {
            if(!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
    public int min(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]<min) {
                min=nums[i];
            }
        }
        return min;
    }
    public int max(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>max) {
                max=nums[i];
            }
        }
        return max;
    }
}
