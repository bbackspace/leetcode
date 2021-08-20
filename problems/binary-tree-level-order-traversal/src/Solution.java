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
    
    private List<List<Integer>> levelOrderTraversal;
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderTraversal = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        if (root != null) {
            nextLevel.add(root);
        }
        while(nextLevel.size() > 0) {
            nextLevel = getNextLevel(nextLevel);
        }
        return levelOrderTraversal;
    }
    
    private List<TreeNode> getNextLevel(List<TreeNode> level) {
        List<TreeNode> nextLevel = new ArrayList<>();
        List<Integer> levelValues = new ArrayList<>();
        for (TreeNode node: level) {
            levelValues.add(node.val);
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }
        levelOrderTraversal.add(levelValues);
        return nextLevel;
    }
}

