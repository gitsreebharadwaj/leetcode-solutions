class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1=nums1.length;
        int len2=nums2.length;
        int len=Math.max(len1, len2);
        int[] res=new int[len];
        int i=0;
        int j=0;
        int idx=0;
        while(i<len1 && j<len2) {
            if(nums1[i]<nums2[j]) {
                i++;
            }
            else if(nums1[i]>nums2[j]) {
                j++;
            }
            else {
                if(idx==0 || res[idx-1]!=nums1[i]) {
                    res[idx++]=nums1[i];
                }
                i++;
                j++;
            }
        }
        return Arrays.copyOf(res, idx);
    }
}
