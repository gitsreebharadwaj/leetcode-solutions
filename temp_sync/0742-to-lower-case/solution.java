class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
