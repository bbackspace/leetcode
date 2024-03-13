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
    public ListNode removeZeroSumSublists(ListNode head) {
        var list = new ArrayList<ListNode>();
        list.add(new ListNode(0, head));
        for (ListNode p = head; p != null; p = p.next) {
            list.add(p);
        }
        var prefixSum = new ArrayList<Integer>();
        int n = list.size() - 1;
        prefixSum.add(list.get(1).val);
        for (int i = 1; i < n; i++) {
            prefixSum.add(prefixSum.get(i - 1) + list.get(i + 1).val);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (prefixSum.get(j) == (i == 0 ? 0 : prefixSum.get(i - 1))) {
                    list.get(i).next = list.get(j + 1).next;
                }
            }
        }
        return list.get(0).next;
    }
}
