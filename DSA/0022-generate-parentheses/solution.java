class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        int open=0;
        int close=0;
        solve(ans, open, close, "", n);
        return ans;
    }
    public void solve(List<String> ans, int open, int close, String curr, int n) {
        if(curr.length()==2*n) {
            ans.add(curr);
            return;
        }
        if(open<n) {
            solve(ans, open+1, close, curr+"(", n);
        }
        if(open>close) {
            solve(ans, open, close+1, curr+")", n);
        }
    }
}
