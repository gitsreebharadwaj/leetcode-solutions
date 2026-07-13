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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode tail=head;
        int len=1;
        while(tail.next!=null) {
            len++;
            tail=tail.next;
        }
        if(k%len==0) {
            return head;
        }
        k=k%len;
        tail.next=head;
        ListNode newLastNode=findNewLastNode(head, len-k);
        head=newLastNode.next;
        newLastNode.next=null;
        return head;
    }
    public ListNode findNewLastNode(ListNode head, int k) {
        int cnt=0;
        ListNode temp=head;
        while(temp!=null) {
            cnt++;
            if(cnt==k) {
                break;
            }
            temp=temp.next;
        }
        return temp;
    }
}
