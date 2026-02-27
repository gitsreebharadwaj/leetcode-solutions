class Solution {
    public int romanToInt(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            int val=0;
            if(ch=='I') {
                val=1;
            }
            else if(ch=='V') {
                val=5;
            }
            else if(ch=='X') {
                val=10;
            }
            else if(ch=='L') {
                val=50;
            }
            else if(ch=='C') {
                val=100;
            }
            else if(ch=='D') {
                val=500;
            }
            else if(ch=='M') {
                val=1000;
            }
            else {
                return -1;
            }
            if(i<s.length()-1) {
                char next=s.charAt(i+1);
                int nextVal=0;
                if(next=='I') {
                    nextVal=1;
                }   
                else if(next=='V') {
                    nextVal=5;
                }
                else if(next=='X') {
                    nextVal=10;
                }
                else if(next=='L') {
                    nextVal=50;
                }
                else if(next=='C') {
                    nextVal=100;
                }
                else if(next=='D') {
                    nextVal=500;
                }
                else if(next=='M') {
                    nextVal=1000;
                }
                else {
                    return -1;
                }
                if(val<nextVal) {
                    res-=val;
                    continue;
                }
            }
            res+=val;
        }
        return res;
    }
}
