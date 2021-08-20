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
    private ListNode add(ListNode l1, ListNode l2, int carry) {
        int sum = 0;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }
        sum += carry;
        if (sum == 0 && l1 == null && l2 == null) {
            return null;
        } else {
            ListNode next = add((l1 != null ? l1.next : null),
                               (l2 != null ? l2.next : null),
                               sum / 10);
            return new ListNode(sum % 10, next);
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = add(l1, l2, 0);
        if (sum == null) {
            return new ListNode(0);
        }
        return sum;
    }
}

