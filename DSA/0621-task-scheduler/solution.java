class Solution {
    public int leastInterval(char[] tasks, int n) {
        int timer=0;
        int[] map=new int[26];
        for(char ch : tasks) {
            map[ch-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->Integer.compare(b, a));
        for(int freq : map) {
            if(freq>0) {
                pq.offer(freq);
            }
        }
        while(!pq.isEmpty()) {
            List<Integer> temp=new ArrayList<>();
            for(int i=1; i<=n+1; i++) {
                if(!pq.isEmpty()) {
                    int freq=pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }
            for(int f : temp) {
                if(f>0) {
                    pq.offer(f);
                }
            }
            if(pq.isEmpty()) {
                timer+=temp.size();
            }
            else {
                timer+=n+1;
            }
        }
        return timer;
    }
}
