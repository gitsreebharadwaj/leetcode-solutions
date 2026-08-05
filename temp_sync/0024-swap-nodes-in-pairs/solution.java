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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        ListNode p1=head;
        ListNode p2=head.next;
        while(p1!=null && p2!=null) {
            ListNode nextP1=p2.next;
            ListNode nextP2=(nextP1!=null) ? nextP1.next : null;
            temp.next=p2;
            temp.next.next=p1;
            p1.next=nextP1;
            temp=p1;
            p1=nextP1;
            p2=nextP2;
        }
        return dummy.next;
    } 
}
