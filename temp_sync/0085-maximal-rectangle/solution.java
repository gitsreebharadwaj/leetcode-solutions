class Solution {
    public int LHist(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()]>heights[i]) {
                int idx=st.pop();
                int nse=i;
                int pse=(st.isEmpty()) ? -1 : st.peek();
                maxArea=Math.max(maxArea, heights[idx]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int idx=st.pop();
            int nse=n;
            int pse=(st.isEmpty()) ? -1 : st.peek();
            maxArea=Math.max(maxArea, heights[idx]*(nse-pse-1));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return 0;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] psum=new int[n][m];
        int maxArea=0;
        for(int j=0; j<m; j++) {
            int sum=0;
            for(int i=0; i<n; i++) {
                if(matrix[i][j]=='0') {
                    sum=0;
                }
                else {
                    sum+=1;
                }
                psum[i][j]=sum;
            }
        }
        for(int i=0; i<n; i++) {
            maxArea=Math.max(maxArea, LHist(psum[i]));
        }
        return maxArea;
    }
}
