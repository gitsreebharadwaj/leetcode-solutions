class Solution {
    private int cnt=0;
    public void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp.add(arr[left++]);
            else
                temp.add(arr[right++]);
        }
        while (left <= mid)
            temp.add(arr[left++]);
        while (right <= high)
            temp.add(arr[right++]);
        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low);
    }
    public void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
    }
    void countPairs(int[] nums, int low, int mid, int high) {
        int right=mid+1;
        for(int i=low; i<=mid; i++) {
            while(right<=high && nums[i]>2*(long)nums[right]) right++;
            cnt+=(right-(mid+1));
        }
    }
    public int reversePairs(int[] nums) {
        cnt=0;
        mergeSort(nums, 0, nums.length-1);
        return cnt;
    }
}
