class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n=arr.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++) {
            int num=arr[i];
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }
            else {
                map.put(num, 1);
            }
        }
        Map<Integer, Integer> mapcheck=new HashMap<>();
        boolean result=true;
        for(int count : map.values()) {
            if(mapcheck.containsKey(count)) {
                result=false;
                break;
            }
            else {
                mapcheck.put(count, 1);
            }
        }
        return result;
    }
}
