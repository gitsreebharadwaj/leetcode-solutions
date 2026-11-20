class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack=new ArrayDeque<>();
        Deque<String> stringStack=new ArrayDeque<>();
        StringBuilder ans=new StringBuilder();
        StringBuilder currString=new StringBuilder();
        int k=0;
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k=k*10+(ch-'0');
            }
            else if(ch=='[') {
                countStack.push(k);
                stringStack.push(currString.toString());
                currString.setLength(0);
                k=0;
            }
            else if(ch==']') {
                int repeat=countStack.pop();
                String currSegment=currString.toString();
                currString.setLength(0);
                currString.append(stringStack.pop());
                for(int i=0; i<repeat; i++) {
                    currString.append(currSegment);
                }
            }
            else {
                currString.append(ch);
            }
        }
        ans.append(currString);
        return ans.toString();
    }
}
