class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
    }
    public long sumSubarrayMaxs(int[] arr) {
        int n=arr.length;
        int mod=1_000_000_000+7;
        int[] pge=findPGE(arr, n);
        int[] nge=findNGE(arr, n);
        long total=0;
        for(int i=0; i<n; i++) {
            long left=i-pge[i];
            long right=nge[i]-i;
            total=(total+(left*right)*arr[i]);
        }
        return total;
    }
    public long sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=1_000_000_000+7;
        int[] pse=findPSE(arr, n);
        int[] nse=findNSE(arr, n);
        long total=0;
        for(int i=0; i<n; i++) {
            long left=i-pse[i];
            long right=nse[i]-i;
            total=(total+(left*right)*arr[i]);
        }
        return total;
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
    public int[] findNGE(int[] arr, int n) {
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[i]>=arr[st.peek()]) {
                st.pop();
            }
            nge[i]=(st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        return nge;
    }
    public int[] findPGE(int[] arr, int n) {
        Stack<Integer> st=new Stack<>();
        int[] pge=new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[i]>arr[st.peek()]) {
                st.pop();
            }
            pge[i]=(st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }
}
