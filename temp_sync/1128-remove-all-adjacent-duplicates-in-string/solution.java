class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> st=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            if(st.isEmpty() || st.peek()!=ch) {
                st.push(ch);
            }
            else if(st.peek()==ch) {
                st.pop();
            }
        }
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
