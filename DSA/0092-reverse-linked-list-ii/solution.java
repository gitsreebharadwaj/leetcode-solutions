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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) {
            return head;
        }
        ListNode dummy=new ListNode(-501);
        dummy.next=head;
        ListNode leftPrev=dummy;
        for(int i=0; i<left-1; i++) {
            leftPrev=leftPrev.next;
        }
        ListNode leftNode=leftPrev.next;
        ListNode rightNode=leftNode;
        for(int i=0; i<right-left; i++) {
            rightNode=rightNode.next;
        }
        ListNode rightNext=rightNode.next;
        ListNode prev=null;
        ListNode curr=leftNode;
        while(curr!=rightNext) {
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        leftPrev.next=prev;
        leftNode.next=rightNext;
        return dummy.next;
    }
}
