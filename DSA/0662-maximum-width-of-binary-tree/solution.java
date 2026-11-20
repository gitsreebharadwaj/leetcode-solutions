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
 class Pair {
    TreeNode node;
    int idx;
    Pair(TreeNode node, int idx) {
        this.node=node;
        this.idx=idx;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int width=0;
        Queue<Pair> q=new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size=q.size();
            int minIdx=q.peek().idx;
            int first=0;
            int last=0;
            for(int i=0; i<size; i++) {
                Pair curr=q.poll();
                int currIdx=curr.idx;
                TreeNode currNode=curr.node;
                if(i==0) {
                    first=currIdx;
                }
                if(i==size-1) {
                    last=currIdx;
                }
                if(currNode.left!=null) {
                    q.offer(new Pair(currNode.left, currIdx*2+1));
                }
                if(currNode.right!=null) {
                    q.offer(new Pair(currNode.right, currIdx*2+2));
                }
            }
            width=Math.max(width, last-first+1);
        }
        return width;
    }
}
