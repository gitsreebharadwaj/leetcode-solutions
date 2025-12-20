class Solution {
    public int removeDuplicates(int[] arr) {
        if(arr==null)
            return 0;
        int k=1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i]!=arr[k-1]) {
                arr[k]=arr[i];
                k++;
            }
        }
        return k;
    }
}
