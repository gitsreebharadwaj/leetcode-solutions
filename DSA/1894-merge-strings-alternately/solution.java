class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int l=0;
        int r=0;
        boolean flag=true;
        while(l<word1.length() && r<word2.length()) {
            if(flag) {
                sb.append(word1.charAt(l));
                l++;
                flag=!flag;
            }
            else {
                sb.append(word2.charAt(r));
                r++;
                flag=!flag;
            }
        }
        while(l<word1.length()) {
            sb.append(word1.charAt(l));
            l++;
        }
        while(r<word2.length()) {
            sb.append(word2.charAt(r));
            r++;
        }  
        return sb.toString();
    }
}
