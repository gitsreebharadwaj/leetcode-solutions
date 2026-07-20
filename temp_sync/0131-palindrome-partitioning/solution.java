class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> path=new ArrayList<>();
        solve(ans, path, 0, s);
        return ans;
    }
    public void solve(List<List<String>> ans, List<String> path, int idx, String s) {
        if(idx==s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx; i<s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i+1));
                solve(ans, path, i+1, s);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        while(start<=end) {
            if(s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
