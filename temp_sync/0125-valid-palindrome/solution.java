class Solution {
    public boolean isPalindrome(String s) {
        String temp=s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        String reverse=new StringBuilder(temp).reverse().toString();
        if(temp.equals(reverse)) {
            return true;
        }
        return false;
    }
}
