class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) {
            return false;
        }
        int n=s.length();
        if(n==0) {
            return true;
        }
        char[] goalArr=goal.toCharArray();
        for(int i=0; i<n; i++) {
            if(Arrays.equals(rotate(s.toCharArray(), i, n), goalArr)) {
                return true;
            }
        }
        return false;
    }
    public char[] rotate(char[] arr, int d, int n) {
        if(d==0) {
            return arr;
        }
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
        return arr;
    }
    public void reverse(char[] arr, int l, int r) {
        while(l<r) {
            char temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
}
