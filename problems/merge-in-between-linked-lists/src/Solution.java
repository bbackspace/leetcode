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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode slowPrev = list1;
        ListNode fast = list1.next;
        for (int i = 0; i < b - a; i++) {
            fast = fast.next;
        }
        for (int i = 1; i < a; i++) {
            slowPrev = slowPrev.next;
            fast = fast.next;
        }
        ListNode list2last = list2;
        while (list2last.next != null) {
            list2last = list2last.next;
        }
        slowPrev.next = list2;
        list2last.next = fast.next;
        return list1;
    }
}
