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
    public ListNode deleteDuplicates(ListNode head) {
       ListNode prev=null;
       ListNode curr=null;
       ListNode temp=head;
       while(temp!=null) {
        curr=temp;
        if(prev!=null &&curr.val==prev.val) {
            prev.next=curr.next;
            temp=temp.next;
        }
        else {
        temp=temp.next;
        prev=curr;
        }
       }
       return head;
    }
}
