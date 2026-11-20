class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, 0, candidates, target, ans, curr);
        return ans;
    }
    public void findCombinations(int idx, int sum, int[] arr, int target, List<List<Integer>> ans, List<Integer> curr) {
        if(sum==target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target) {
            return;
        }
        for(int i=idx; i<arr.length; i++) {
            if(i!=idx && arr[i]==arr[i-1]) continue;
            if(sum+arr[i]>target) break;
            curr.add(arr[i]);
            findCombinations(i+1, sum+arr[i], arr, target, ans, curr);
            curr.remove(curr.size()-1);
        }
    }
}
