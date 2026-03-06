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
        ListNode cur=head;
        int grp=0;
        while(cur!=null && grp<k){
            cur=cur.next;grp++;
        }
        if(grp==k){
            cur=reverseKGroup(cur,k);
            while(grp>0){
                ListNode temp=head.next;
                head.next=cur;
                cur=head;
                head=temp;
                grp--;
            }
            head=cur;
        }
        return head;
    }
}