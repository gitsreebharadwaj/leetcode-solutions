class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> chartoword=new HashMap<>();
        Map<String, Character> wordtochar=new HashMap<>();
        String[] words=s.split(" ");
        if(pattern.length()!=words.length) {
            return false;
        }
        for(int i=0; i<words.length; i++) {
            char ch=pattern.charAt(i);
            String word=words[i];
            if(chartoword.containsKey(ch) && !chartoword.get(ch).equals(word)) {
                return false;
            }
            if(wordtochar.containsKey(word) && wordtochar.get(word)!=ch) {
                return false;
            }
            chartoword.put(ch, word);
            wordtochar.put(word, ch);
        }
        return true;
    }
}
