class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=1_000_000_000+7;
        int[] pse=findPSE(arr, n);
        int[] nse=findNSE(arr, n);
        long total=0;
        for(int i=0; i<n; i++) {
            long left=i-pse[i];
            long right=nse[i]-i;
            total=(total+(left*right%mod)*arr[i])%mod;
        }
        return (int)total;
    }
    public int[] findNSE(int[] arr, int n) {
        Stack<Integer> st=new Stack<>();
        int[] nse=new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]) {
                st.pop();
            }
            nse[i]=(st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findPSE(int[] arr, int n) {
        Stack<Integer> st=new Stack<>();
        int[] pse=new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[i]<arr[st.peek()]) {
                st.pop();
            }
            pse[i]=(st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}
