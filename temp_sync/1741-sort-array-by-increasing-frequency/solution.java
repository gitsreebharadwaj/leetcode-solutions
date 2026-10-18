class Solution {
    public int[] frequencySort(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int num : nums) {
            list.add(num);
        }
        Collections.sort(list, (a, b)-> {
        int freqA=map.get(a);
        int freqB=map.get(b);
        return freqA!=freqB ? Integer.compare(freqA, freqB) : Integer.compare(b, a);
        });
        for(int i=0; i<n; i++) {
            nums[i]=list.get(i);
        }
        return nums;
    }
}
