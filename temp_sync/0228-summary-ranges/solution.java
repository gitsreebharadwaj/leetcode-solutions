class Solution {
    public List<String> summaryRanges(int[] nums) {
       List<String> ans=new ArrayList<>();
       Set<Integer> set=new LinkedHashSet<>();
       for(int num : nums) {
        set.add(num);
       }
       for(int num : nums) {
        if(!set.contains(num)) {
            continue;
        }
        int start=num;
        int x=num;
        while(set.contains(x)) {
            set.remove(x);
            x++;
        }
        int end=x-1;
        if(start==end) {
            ans.add(String.valueOf(start));
        }
        else {
            ans.add(start+"->"+end);
        }
        }
        return ans;
    }
}
