class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] nge=new int[n];
        Map<Integer, Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int i=m-1; i>=0; i--) {
            while(!st.isEmpty() && nums2[i]>=st.peek()) {
                st.pop();
            }
            if(st.isEmpty()) {
                map.put(nums2[i], -1);
            }
            else {
                map.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }
        for(int i=0; i<n; i++) {
            nge[i]=map.get(nums1[i]);
        }
        return nge;
    }
}
