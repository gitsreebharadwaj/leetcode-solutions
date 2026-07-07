class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) {
            return false;
        }
        Stack<Character> stack=new Stack<>();
        Map<Character, Character> map=new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(char ch : s.toCharArray()) {
            if(map.containsKey(ch)) {
                if(stack.isEmpty() || stack.peek()!=map.get(ch)) {
                    return false;
                }
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
