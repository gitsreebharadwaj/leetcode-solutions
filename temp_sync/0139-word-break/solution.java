class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet=new HashSet<>(wordDict);
        boolean[] failedIndices=new boolean[s.length()];
        return solve(0, s, wordSet, failedIndices);
    }
    public boolean solve(int idx, String s, Set<String> wordSet, boolean[] failedIndices) {
        if(idx==s.length()) {
            return true;
        }
        if(failedIndices[idx]) {
            return false;
        }
        for(int i=idx; i<s.length(); i++) {
            String part=s.substring(idx, i+1);
            if(wordSet.contains(part)) {
                if(solve(i+1, s, wordSet, failedIndices)) {
                    return true;
                }
            }
        }
        failedIndices[idx]=true;
        return false;
    }
}
