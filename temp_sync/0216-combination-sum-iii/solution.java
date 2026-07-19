class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        solve(n, k, 1, ans, curr);
        return ans;
    }
    public void solve(int sum, int k, int last, List<List<Integer>> ans, List<Integer> curr) {
        if(curr.size()==k && sum==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum<=0 || curr.size()>=k) {
            return;
        }
        for(int i=last; i<=9; i++) {
            if(i<=sum) {
                curr.add(i);
                solve(sum-i, k, i+1, ans, curr);
                curr.remove(curr.size()-1);
            }
            else {
                break;
            }
        }
    }
}
