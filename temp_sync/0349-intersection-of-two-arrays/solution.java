class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int i : nums1) {
            set1.add(i);
        }
        for(int i : nums2) {
            set2.add(i);
        }
        TreeSet<Integer> intersection=new TreeSet<>(set1);
        intersection.retainAll(set2);
        int[] arr=new int[intersection.size()];
        int idx=0;
        for(int i : intersection) {
            arr[idx++]=i;
        }
        return arr;
    }
}
