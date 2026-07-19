class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        findCombinations(0, 0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
    public void findCombinations(int idx, int sum, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
        if(sum>target) {
            return;
        }
        if(idx==arr.length) {
            if(sum==target) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        ds.add(arr[idx]);
        findCombinations(idx, sum+arr[idx], target, arr, ans, ds);
        ds.remove(ds.size()-1);
        findCombinations(idx+1, sum, target, arr, ans, ds);
    }
}
