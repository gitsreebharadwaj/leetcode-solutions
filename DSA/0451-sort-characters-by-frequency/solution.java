class Solution {
    public String frequencySort(String s) {
        int[] freq=new int[126];
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            freq[ch]++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<freq.length; i++) {
            int maxIdx = maxIndex(freq);
            if (freq[maxIdx] == 0) {
                break;
            }
            char maxc=(char)maxIdx;
            for(int cnt=0; cnt<freq[maxIdx]; cnt++) {
                sb.append(maxc);
            }
            freq[maxIdx]=0;
        }
        return sb.toString();
    }
    public int maxIndex(int[] freq) {
        int maxIdx=0;
        for(int i=0; i<freq.length; i++) {
            if(freq[i]>freq[maxIdx]) {
                maxIdx=i;
            }
        }
        return maxIdx;
    }
}
