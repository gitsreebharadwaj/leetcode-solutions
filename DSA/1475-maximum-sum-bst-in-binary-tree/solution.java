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
class NodeValue {
    int minNode;
    int maxNode;
    int sum;
    NodeValue(int minNode, int maxNode, int sum) {
        this.minNode=minNode;
        this.maxNode=maxNode;
        this.sum=sum;
    }
}
class Solution {
    private int maxSum=0;
    public int maxSumBST(TreeNode root) {
        maxSum=0;
        sumBSTHelper(root);
        return maxSum;
    }
    public NodeValue sumBSTHelper(TreeNode root) {
        if(root==null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left=sumBSTHelper(root.left);
        NodeValue right=sumBSTHelper(root.right);
        if(left.maxNode<root.val && right.minNode>root.val) {
            int currSum=root.val+left.sum+right.sum;
            maxSum=Math.max(maxSum, currSum);
            return new NodeValue(
                Math.min(root.val, left.minNode),
                Math.max(root.val, right.maxNode),
                currSum
            );
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}
