/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent=new HashMap<>();
        markParents(root, parent, target);
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode, Boolean> vis=new HashMap<>();
        int level=0;
        q.offer(target);
        vis.put(target, true);
        while(!q.isEmpty()) {
            if(level==k) {
                break;
            }
            level++;
            int size=q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr=q.poll();
                if(curr.left!=null && vis.get(curr.left)==null) {
                    q.offer(curr.left);
                    vis.put(curr.left, true);
                }
                if(curr.right!=null && vis.get(curr.right)==null) {
                    q.offer(curr.right);
                    vis.put(curr.right, true);
                }
                if(parent.get(curr)!=null && vis.get(parent.get(curr))==null) {
                    q.offer(parent.get(curr));
                    vis.put(parent.get(curr), true);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode curr=q.poll();
            ans.add(curr.val);
        }
        return ans;
    }
    public void markParents(TreeNode root, Map<TreeNode, TreeNode> parent, TreeNode target) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr=q.poll();
            if(curr.left!=null) {
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right!=null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
}
