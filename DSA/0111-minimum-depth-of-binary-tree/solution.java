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
    public int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        if(isLeaf(root)) {
            return 1;
        }
        int lh=root.left!=null ? 1+minDepth(root.left) : Integer.MAX_VALUE;
        int rh=root.right!=null ? 1+minDepth(root.right) : Integer.MAX_VALUE;
        return Math.min(lh, rh);
    }
    private boolean isLeaf(TreeNode root) {
        if(root.left==null && root.right==null) {
            return true;
        }
        return false;
    }
}
