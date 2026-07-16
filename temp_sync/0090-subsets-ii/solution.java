class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public void findSubsets(int idx, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));
        for(int i=idx; i<nums.length; i++) {
            if(i!=idx && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            findSubsets(i+1, nums, curr, ans);
            curr.remove(curr.size()-1);
        }
    }
}
