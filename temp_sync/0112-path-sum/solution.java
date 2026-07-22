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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) {
            return false;
        }
        return solve(root, 0, targetSum);
    }
    public boolean solve(TreeNode root, int csum, int targetSum) {
        if(root==null) {
            return false;
        }
        csum+=root.val;
        if(root.left==null && root.right==null) {
            return csum==targetSum;
        }
        return (solve(root.left, csum, targetSum) || solve(root.right, csum, targetSum));
    }
}
