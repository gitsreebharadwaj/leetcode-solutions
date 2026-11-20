class Solution {
    public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        int l=0;
        int r=s.length()-1;
        while(l<r) {
            if(l<r && !isVowel(s.charAt(l))) {
                l++;
            }
            else if(l<r && !isVowel(s.charAt(r))) {
                r--;
            }
            else if(l<r) {
                char temp=chars[l];
                chars[l]=chars[r];
                chars[r]=temp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }
    public boolean isVowel(char ch) {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
            return true;
        }
        if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
            return true;
        }
        return false;
    }
}
