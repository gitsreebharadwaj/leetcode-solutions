class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n=boxTypes.length;
        Arrays.sort(boxTypes, (a, b)->Integer.compare(b[1], a[1]));
        int totalUnits=0;
        for(int i=0; i<n; i++) {
            int boxCount=boxTypes[i][0];
            int boxUnits=boxTypes[i][1];
            int boxesToTake=Math.min(truckSize, boxCount);
            totalUnits+=boxesToTake*boxUnits;
            truckSize-=boxesToTake;
            if(truckSize==0) {
                break;
            }
        }
        return totalUnits;
    }
}
