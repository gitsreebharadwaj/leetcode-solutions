class Solution {
    public int minSwaps(String s) {
        if(s.length()%2!=0) {
            return -1;
        }
        Stack<Character> st=new Stack<>();
        int mismatch=0;
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            if(ch=='[') {
                st.push(ch);
            }
            else {
                if(!st.isEmpty()) {
                    st.pop();
                }
                else {
                    mismatch++;
                }
            }
        }
        return (mismatch+1)/2;
    }
}
