/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Pair {
    int val;
    ListNode node;
    Pair(int val, ListNode node) {
        this.val=val;
        this.node=node;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->Integer.compare(a.val, b.val));
        for(int i=0; i<lists.length; i++) {
            if(lists[i]!=null) {
                pq.offer(new Pair(lists[i].val, lists[i]));
            }
        }
        ListNode dummyNode=new ListNode(-1);
        ListNode temp=dummyNode;
        while(!pq.isEmpty()) {
            Pair curr=pq.poll();
            int currVal=curr.val;
            ListNode currNode=curr.node;
            if(currNode.next!=null) {
                pq.offer(new Pair(currNode.next.val, currNode.next));
            }
            temp.next=currNode;
            temp=temp.next;
        }
        return dummyNode.next;
    }
}
