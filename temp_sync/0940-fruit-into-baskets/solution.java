class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map=new HashMap<>();
        int n=fruits.length;
        int l=0;
        int r=0;
        int maxFruits=0;
        while(r<n) {
            int rightFruit=fruits[r];
            map.put(rightFruit, map.getOrDefault(rightFruit, 0)+1);
            if(map.size()>2) {
                int leftFruit=fruits[l];
                map.put(leftFruit, map.get(leftFruit)-1);
                if(map.get(leftFruit)==0) {
                    map.remove(leftFruit);
                }
                l++;
            }
            maxFruits=Math.max(maxFruits, r-l+1);
            r++;
        }
        return maxFruits;
    }
}
