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
    // reverse a null-terminated linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode node = head;
        ListNode prev = dummy;
        while (node != null) {
            ListNode subList = node;
            ListNode subListPrev = prev;
            for (int i = 0; i < k; i++) {
                if (node == null) {
                    subListPrev.next = subList; // re-attach the subList without reversing if group smaller than k nodes
                    return dummy.next;
                }
                prev = node;
                node = node.next;
            }
            prev.next = null; // get a null-terminated subList
            subListPrev.next = reverse(subList); // re-attach the subList after reversing
            prev = subList; // our subList was reversed, so prev is now the previous start of the subList
        }
        return dummy.next;
    }
}
