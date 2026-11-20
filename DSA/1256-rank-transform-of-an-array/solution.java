class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] sortedArr=arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer, Integer> map=new HashMap<>();
        int rank=1;
        for(int num : sortedArr) {
            if(!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }
        for(int i=0; i<n; i++) {
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}
