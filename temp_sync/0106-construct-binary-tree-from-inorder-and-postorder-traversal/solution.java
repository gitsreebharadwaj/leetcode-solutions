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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inmap=new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        TreeNode root=solve(inorder, 0, inorder.length-1,
                            postorder, 0, postorder.length-1, inmap);
        return root;
    }
    public TreeNode solve(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inmap) {
        if(inStart>inEnd || postStart>postEnd) {
            return null;
        }
        TreeNode root=new TreeNode(postorder[postEnd]);
        int inRoot=inmap.get(root.val);
        int numsLeft=inRoot-inStart;
        root.left=solve(inorder, inStart, inRoot-1, postorder, postStart, postStart+numsLeft-1, inmap);
        root.right=solve(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1, inmap);
        return root;
    }
}
