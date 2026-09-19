class Solution {
    private int cnt=0;
    public int reversePairs(int[] nums) {
        int n=nums.length;
        mergeSort(nums, 0, n-1);
        return cnt;
    }
     public void mergeSort(int[] arr, int l, int h) {
        if(l>=h) {
            return;
        }
        int mid=(l+h)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, h);
        countPairs(arr, l, mid, h);
        merge(arr, l, mid, h);
    }
    public void merge(int[] arr, int l, int mid, int h) {
        List<Integer> temp=new ArrayList<>();
        int left=l;
        int right=mid+1;
        while(left<=mid && right<=h) {
            if(arr[left]<=arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid) {
            temp.add(arr[left]);
            left++;
        }
        while(right<=h) {
            temp.add(arr[right]);
            right++;
        }
        for(int i=l; i<=h; i++) {
            arr[i]=temp.get(i-l);
        }
    }
    private void countPairs(int[] nums, int l, int mid, int h) {
        int right=mid+1;
        for(int left=l; left<=mid; left++) {
            while(right<=h && nums[left]>(long)2*nums[right]) {
                right++;
            }
            cnt+=(right-(mid+1));
        }
    }
}
