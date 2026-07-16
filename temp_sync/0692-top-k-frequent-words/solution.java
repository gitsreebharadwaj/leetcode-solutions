class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map=new HashMap<>();
        for(int i=0; i<words.length; i++) {
            String temp=words[i];
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        Map<String, Integer> sortedMap=new TreeMap<>((w1, w2)->{
            int freq1=map.get(w1);
            int freq2=map.get(w2);
            if(freq1!=freq2) {
                return Integer.compare(freq2, freq1);
            }
            return w1.compareTo(w2);
        });
        sortedMap.putAll(map);
        List<String> res=new ArrayList<>();
        int idx=0;
        for(String word : sortedMap.keySet()) {
            if(idx==k) {
                break;
            }
            res.add(word);
            idx++;
        }
        return res;
    }
}
