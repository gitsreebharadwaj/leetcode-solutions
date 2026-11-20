class Solution {
    public int maximumSum(int[] nums) {
        List<Integer>[] groups=new ArrayList[3];
        for(int i=0; i<3; i++) {
            groups[i]=new ArrayList<>();
        }
        for(int num : nums) {
            groups[num%3].add(num);
        }
        for(int i=0; i<3; i++) {
            groups[i].sort(Collections.reverseOrder());
        }
        int best=0;
        if(groups[0].size()>=3) {
            best=Math.max(best, groups[0].get(0)+groups[0].get(1)+groups[0].get(2));
        }
        if(groups[1].size()>=3) {
            best=Math.max(best, groups[1].get(0)+groups[1].get(1)+groups[1].get(2));
        }
        if(groups[2].size()>=3) {
            best=Math.max(best, groups[2].get(0)+groups[2].get(1)+groups[2].get(2));
        }
        if(!groups[0].isEmpty() && !groups[1].isEmpty() && !groups[2].isEmpty()) {
            best=Math.max(best, groups[0].get(0)+groups[1].get(0)+groups[2].get(0));
        }
        return best;
    }
}
