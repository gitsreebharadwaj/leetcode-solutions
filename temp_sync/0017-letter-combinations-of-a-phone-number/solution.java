class Solution {
    private final String[] map;
    public Solution() {
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits==null || digits.length()==0) {
            return ans;
        }
        finder(digits, 0, "", ans);
        return ans;
    }
    public void finder(String digits, int idx, String curr, List<String> ans) {
        if(idx==digits.length()) {
            ans.add(curr);
            return;
        }
        String s=map[digits.charAt(idx)-'0'];
        for(int i=0; i<s.length(); i++) {
            finder(digits, idx+1, curr+s.charAt(i), ans);
        }
    }
}
