/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) {
            return false;
        }
        BSTIterator left=new BSTIterator(root, false);
        BSTIterator right=new BSTIterator(root, true);
        int l=left.next();
        int r=right.next();
        while(l<r) {
            int sum=l+r;
            if(sum==k) {
                return true;
            }
            else if(sum>k) {
                r=right.next();
            }
            else {
                l=left.next();
            }
        }
        return false;
    } 
}
class BSTIterator {
    private Stack<TreeNode> st=new Stack<>();
    private boolean reverse=true;
    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse=isReverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode curr=st.pop();
        if(!reverse) {
            pushAll(curr.right);
        }
        else {
            pushAll(curr.left);
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(TreeNode root) {
        while(root!=null) {
            st.push(root);
            if(reverse) {
                root=root.right;
            }
            else {
                root=root.left;
            }
        }
    }
}
