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
    private static class Result {
        int val;
        int numNodes;
        
        private Result(int val, int numNodes) {
            this.val = val;
            this.numNodes = numNodes;
        }
    }
    private Result kthRec(TreeNode node, int k, int numNodesLeft) {
        if (node == null) {
            return new Result(-1, 0);
        }
        Result left = kthRec(node.left, k, numNodesLeft);
        Result right = kthRec(node.right, k, numNodesLeft + 1 + left.numNodes);
        int val = -1;
        if (left.val != -1) {
            val = left.val;
        } else if (numNodesLeft + left.numNodes + 1 == k) {
            val = node.val;
        } else if (right.val != -1) {
            val = right.val;
        }
        return new Result(val, left.numNodes + right.numNodes + 1);
    }
    public int kthSmallest(TreeNode root, int k) {
        return kthRec(root, k, 0).val;
    }
}

