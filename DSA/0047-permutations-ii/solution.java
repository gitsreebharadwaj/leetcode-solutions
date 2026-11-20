class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        boolean[] vis=new boolean[n];
        Arrays.sort(nums);
        solve(ans, curr, vis, nums, 0, n);
        return ans;
    }
    private void solve(List<List<Integer>> ans, List<Integer> curr, boolean[] vis,
    int[] nums, int idx, int n) {
        if(idx==n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                if(i>0 && nums[i]==nums[i-1] && !vis[i-1]) {
                    continue;
                }
                vis[i]=true;
                curr.add(nums[i]);
                solve(ans, curr, vis, nums, idx+1, n);
                curr.remove(curr.size()-1);
                vis[i]=false;
            }
        }
    }
}
