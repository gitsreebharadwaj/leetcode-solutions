class Solution {
    Map<String, Integer> map=new HashMap<>();
    public void dfs(String word, String beginWord, List<List<String>> ans, List<String> seq) {
        if(word.equals(beginWord)) {
            Collections.reverse(seq);
            ans.add(new ArrayList<>(seq));
            Collections.reverse(seq);
            return;
        }
        char[] chars=word.toCharArray();
        int steps=map.get(word);
        for(int i=0; i<chars.length; i++) {
            char originalChar=chars[i];
            for(char ch='a'; ch<='z'; ch++) {
                chars[i]=ch;
                String newWord=new String(chars);
                if(map.containsKey(newWord) && map.get(newWord)+1==steps) {
                    seq.add(newWord);
                    dfs(newWord, beginWord, ans, seq);
                    seq.remove(seq.size()-1);
                }
            }
            chars[i]=originalChar;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans=new ArrayList<>();
        Set<String> set=new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        map.put(beginWord, 1);
        while(!q.isEmpty()) {
            int size=q.size();
            for(String s : q) {
                set.remove(s);
            }
            for(int k=0; k<size; k++) {
                String word=q.poll();
                int steps=map.get(word);
                char[] chars=word.toCharArray();
                for(int i=0; i<chars.length; i++) {
                    char originalChar=chars[i];
                    for(char ch='a'; ch<='z'; ch++) {
                        chars[i]=ch;
                        String newWord=new String(chars);
                        if(set.contains(newWord)) {
                            if(!map.containsKey(newWord)) {
                                q.offer(newWord);
                                map.put(newWord, steps+1);
                            }
                        }
                    }
                    chars[i]=originalChar;
                }
            }
        }
        if(map.containsKey(endWord)) {
            List<String> seq=new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, beginWord, ans, seq);
        }
        return ans;
    }
}
