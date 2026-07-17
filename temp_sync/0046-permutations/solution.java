class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion(0, nums, ans);
        return ans;
    }
    public void recursion(int idx, int[] arr, List<List<Integer>> ans) {
        if(idx==arr.length) {
            List<Integer> ds=new ArrayList<>();
            for(int i=0; i<arr.length; i++) {
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx; i<arr.length; i++) {
            swap(i, idx, arr);
            recursion(idx+1, arr, ans);
            swap(i, idx, arr);
        }
    }
    public void swap(int idx1, int idx2, int[] arr) {
        int temp=arr[idx1];
        arr[idx1]=arr[idx2];
        arr[idx2]=temp;
    }
}
