class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        Arrays.sort(people);
        int i=0;
        int j=n-1;
        int boats=0;
        while(i<=j) {
            boats++;
            int remaining=limit-people[j];
            if(remaining>=people[i]) {
                i++;
            }
            j--;
        }
        return boats;
    }
}
