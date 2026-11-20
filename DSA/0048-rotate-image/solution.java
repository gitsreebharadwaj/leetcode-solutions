class Solution {
    public void swap(int[][] matrix, int i, int j) {
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    public void reverse(int[][] matrix, int i, int n) {
        int l=0;
        int r=n;
        while(l<r) {
            int temp=matrix[i][l];
            matrix[i][l]=matrix[i][r];
            matrix[i][r]=temp;
            l++;
            r--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                swap(matrix, i, j);
            }
        }
        for(int i=0; i<n; i++) {
            reverse(matrix, i, n-1);
        }
    }
}
