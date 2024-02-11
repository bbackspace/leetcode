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
    private List<TreeNode> trees(int st, int en) {
        List<TreeNode> ans = new ArrayList<>();
        for (int i = st; i <= en; i++) {
            List<TreeNode> left = trees(st, i - 1);
            List<TreeNode> right = trees(i + 1, en);
            for (TreeNode l : left) {
                for (TreeNode r: right) {
                    ans.add(new TreeNode(i, l, r));
                }
            }
            if (left.isEmpty()) {
                for (TreeNode r: right) {
                    ans.add(new TreeNode(i, null, r));
                }
            }
            if (right.isEmpty()) {
                for (TreeNode l: left) {
                    ans.add(new TreeNode(i, l, null));
                }
                if (left.isEmpty()) {
                    ans.add(new TreeNode(i));
                }
            }
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        return trees(1, n);
    }
}
