class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize!=0) {
            return false;
        }
        Map<Integer, Integer> map=new HashMap<>();
        for(int h : hand) {
            map.put(h, map.getOrDefault(h, 0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(map.keySet());
        while(!pq.isEmpty()) {
            int startCard=pq.peek();
            for(int i=0; i<groupSize; i++) {
                int currCard=startCard+i;
                if(!map.containsKey(currCard)) {
                    return false;
                }
                map.put(currCard, map.getOrDefault(currCard, 0)-1);
                if(map.get(currCard)==0) {
                    if(currCard!=pq.peek()) {
                        return false;
                    }
                    pq.poll();
                }
            }
        }
        return true;
    }
}
