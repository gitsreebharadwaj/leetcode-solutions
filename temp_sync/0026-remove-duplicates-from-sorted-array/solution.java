class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set=new LinkedHashSet<>();
        for(int item : nums) {
            set.add(item);
        }
        int idx=0;
        for(int num : set) {
            nums[idx++]=num;
        }
        return set.size();
    }
}
