class Solution {
    public List<String> validStrings(int n) {
        List<String> ans=new ArrayList<>();
        solve(ans, "", n);
        return ans;
    }
    void solve(List<String> ans, String curr, int n) {
        if(curr.length()==n) {
            ans.add(curr);
            return;
        }
        solve(ans, curr+"1", n);
        if(curr.isEmpty() || curr.charAt(curr.length()-1)!='0') {
            solve(ans, curr+"0", n);
        }
    }
}
