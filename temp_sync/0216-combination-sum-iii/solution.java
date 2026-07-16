class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        findCombinations(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }
    public void findCombinations(int sum, int k, int last, List<Integer> curr, List<List<Integer>> ans) {
        if(sum==0 && curr.size()==k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum<=0 || curr.size()>=k) {
            return;
        }
        for(int i=last; i<=9; i++) {
            if(i<=sum) {
                curr.add(i);
                findCombinations(sum-i, k, i+1, curr, ans);
                curr.remove(curr.size()-1);
            }
            else {
                break;
            }
        }
    }
}
