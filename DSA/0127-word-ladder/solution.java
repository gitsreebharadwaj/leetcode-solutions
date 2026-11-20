class Pair {
    String word;
    int steps;
    Pair(String word, int steps) {
        this.word=word;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!q.isEmpty()) {
            Pair curr=q.poll();
            String currWord=curr.word;
            int currSteps=curr.steps;
            if(currWord.equals(endWord)) {
                return currSteps;
            }
            char[] chars=currWord.toCharArray();
            for(int i=0; i<currWord.length(); i++) {
                char originalChar=chars[i];
                for(char ch='a'; ch<='z'; ch++) {
                    chars[i]=ch;
                    String newWord=new String(chars);
                    if(set.contains(newWord)) {
                        q.offer(new Pair(newWord, currSteps+1));
                        set.remove(newWord);
                    }
                }
                chars[i]=originalChar;
            }
        }
        return 0;
    }
}
