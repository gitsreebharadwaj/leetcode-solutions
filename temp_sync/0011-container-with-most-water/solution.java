class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int start=0;
        int end=n-1;
        int maxWater=0;
        while(start<end) {
            int width=end-start;
            int currentHeight=Math.min(height[start], height[end]);
            int currentWater=currentHeight*width;
            maxWater=Math.max(currentWater, maxWater);
            if(height[start]<height[end]) {
                start++;
            }
            else {
                end--;
            }
        }
        return maxWater;
    }
}
