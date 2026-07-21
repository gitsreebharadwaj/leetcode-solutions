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
class Triplet {
    TreeNode node;
    int vertical;
    int level;
    Triplet(TreeNode node, int vertical, int level) {
        this.node=node;
        this.vertical=vertical;
        this.level=level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map=new TreeMap<>();
        Queue<Triplet> q=new LinkedList<>();
        q.offer(new Triplet(root, 0, 0));
        while(!q.isEmpty()) {
            Triplet curr=q.poll();
            TreeNode node=curr.node;
            int vertical=curr.vertical;
            int level=curr.level;
            if(!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new ArrayList<>());
            }
            map.get(vertical).get(level).add(node.val);
            if(node.left!=null) {
                q.offer(new Triplet(node.left, vertical-1, level+1));
            }
            if(node.right!=null) {
                q.offer(new Triplet(node.right, vertical+1, level+1));
            }
        }
        for(TreeMap<Integer, List<Integer>> levels : map.values()) {
            List<Integer> colList=new ArrayList<>();
            for(List<Integer> cellList : levels.values()) {
                Collections.sort(cellList);
                colList.addAll(cellList);
            }
            ans.add(colList);
        }
        return ans;
    }
}
