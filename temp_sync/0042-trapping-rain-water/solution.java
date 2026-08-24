class Solution {
    public int trap(int[] height) {
        int n=height.length;
        Stack<Integer> st=new Stack<>();
        int totalWater=0;
        for(int curr=0; curr<n; curr++) {
            while(!st.isEmpty() && height[curr]>height[st.peek()]) {
                int topIdx=st.pop();
            if(st.isEmpty()) {
                break;
            }
            int currTopIdx=st.peek();
            int boundaryHeight=Math.min(height[curr], height[currTopIdx])-height[topIdx];
            int width=curr-currTopIdx-1;
            totalWater+=boundaryHeight*width;
            }
            st.push(curr);
        }
        return totalWater;
    }
}
