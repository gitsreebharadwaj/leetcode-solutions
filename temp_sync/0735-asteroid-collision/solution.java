class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int ast : asteroids) {
            boolean alive=true;
            while(!st.isEmpty() && ast<0 && st.peek()>0) {
                if(st.peek()<Math.abs(ast)) {
                    st.pop();
                    continue;
                }
                else if(st.peek()==Math.abs(ast)) {
                    st.pop();
                }
                alive=false;
                break;
            }
            if(alive) {
                st.push(ast);
            }
        }
        int[] res=new int[st.size()];
        for(int i=res.length-1; i>=0; i--) {
            res[i]=st.pop();
        }
        return res;
    }
}
