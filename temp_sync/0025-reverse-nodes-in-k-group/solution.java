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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) {
            return head;
        }
        ListNode temp=head;
        ListNode prevNode=null;
        ListNode nextNode=null;
        while(temp!=null) {
            ListNode kthNode=findkthNode(temp, k);
            if(kthNode==null) {
                if(prevNode!=null) {
                    prevNode.next=temp;
                }
                break;
            }
            nextNode=kthNode.next;
            kthNode.next=null;
            reverseLL(temp);
            if(temp==head) {
                head=kthNode;
            }
            else {
                prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
    public ListNode findkthNode(ListNode head, int k) {
        ListNode temp=head;
        while(temp!=null && k>1) {
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseLL(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode newHead=reverseLL(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}
