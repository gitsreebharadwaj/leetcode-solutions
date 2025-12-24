class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> map=new HashMap<>();
        String first=words[0];
        for(int i=0; i<first.length(); i++) {
            char ch=first.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            }
            else {
                map.put(ch, 1);
            }
        }
        for(int i=0; i<words.length; i++) {
            HashMap<Character, Integer> temp=new HashMap<>();
            String word=words[i];
            for(int j=0; j<word.length(); j++) {
                char ch=word.charAt(j);
                if(temp.containsKey(ch)) {
                    temp.put(ch, temp.get(ch)+1);
                }
                else {
                    temp.put(ch, 1);
                }
            }
            for(char ch : map.keySet()) {
                if(temp.containsKey(ch)) {
                    int min=map.get(ch)<temp.get(ch)?map.get(ch):temp.get(ch);
                    map.put(ch, min);
                }
                else {
                    map.put(ch, 0);
                }
            }
        }
        List<String> result=new ArrayList<>();
        for(char ch : map.keySet()) {
            int count=map.get(ch);
            for(int i=0; i<count; i++) {
                result.add(Character.toString(ch));
            }
        }
        return result;
    }
}
