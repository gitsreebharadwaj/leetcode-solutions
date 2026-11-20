class Solution {
    public int maxNumberOfBalloons(String text) {
       Map<Character, Integer> map=new HashMap<>();
       for(int i=0; i<text.length(); i++) {
        char ch=text.charAt(i);
        if(map.containsKey(ch)) {
            map.put(ch, map.get(ch)+1);
        }
        else {
            map.put(ch, 1);
        }
       }
       int result=Integer.MAX_VALUE;
       if(map.containsKey('b')) {
        result=Math.min(result, map.get('b'));
       }
       else {
        return 0;
       }
        if(map.containsKey('a')) {
        result=Math.min(result, map.get('a'));
       }
       else {
        return 0;
       }
        if(map.containsKey('l')) {
        result=Math.min(result, map.get('l')/2);
       }
       else {
        return 0;
       }
        if(map.containsKey('o')) {
        result=Math.min(result, map.get('o')/2);
       }
       else {
        return 0;
       }
        if(map.containsKey('n')) {
        result=Math.min(result, map.get('n'));
       }
       else {
        return 0;
       }
       return result;
    }
}
