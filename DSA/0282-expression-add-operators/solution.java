class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", res);
        return res;
    }
    public void dfs(String num, int target, int st, long currVal, long lastOperand, String expression, List<String> res) {
        if(st==num.length()) {
            if(currVal==target) {
                res.add(expression);
            }
            return;
        }
        for(int i=st; i<num.length(); i++) {
            if(i>st && num.charAt(st)=='0') return;
            String currNum=num.substring(st, i+1);
            long currNumVal=Long.parseLong(currNum);
            if(st==0) {
                dfs(num, target, i+1, currNumVal, currNumVal, currNum, res);
            }
            else {
                dfs(num, target, i+1, currVal+currNumVal, currNumVal, expression+"+"+currNum, res);
                dfs(num, target, i+1, currVal-currNumVal, -currNumVal, expression+"-"+currNum, res);
                dfs(num, target, i+1, currVal-lastOperand+(lastOperand*currNumVal), lastOperand*currNumVal, expression+"*"+currNum, res);
            }
        }
    }
}
