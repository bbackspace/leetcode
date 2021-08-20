/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Pair<Integer, Integer> deepestLeavesSumR(TreeNode node) {
        if (node == null) {
            return new Pair(0, 0);
        }
        if (node.left == null && node.right == null) {
            return new Pair(node.val, 1);
        }
        int sum = 0;
        int level = 0;
        Pair<Integer, Integer> left = deepestLeavesSumR(node.left);
        Pair<Integer, Integer> right = deepestLeavesSumR(node.right);
        if (left.getValue() > right.getValue()) {
            sum = left.getKey();
            level = left.getValue();
        } else if (left.getValue() < right.getValue()) {
            sum = right.getKey();
            level = right.getValue();
        } else {
            sum = left.getKey() + right.getKey();
            level = right.getValue();
        }
        return new Pair(sum, 1 + level);
    }
    public int deepestLeavesSum(TreeNode root) {
        return deepestLeavesSumR(root).getKey();
    }
}

