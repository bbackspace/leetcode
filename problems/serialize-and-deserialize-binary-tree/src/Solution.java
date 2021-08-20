/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private String serList(List<TreeNode> list) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (TreeNode node : list) {
            if (!first) {
                sb.append("\n");
            }
            if (node != null) {
                sb.append(node.val);
            } else {
                sb.append("n");
            }
            first = false;
        }
        return sb.toString();
    }
    
    private List<TreeNode> deserList(String data) {
        String[] lines = data.split("\\n");
        List<TreeNode> levelOrder = new ArrayList<>();
        for (String line: lines) {
            if (line.startsWith("n")) {
                levelOrder.add(null);
            } else {
                levelOrder.add(new TreeNode(Integer.parseInt(line)));
            }
        }
        return levelOrder;
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<TreeNode> lo = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        boolean allnull;
        do {
            List<TreeNode> nextLevel = new ArrayList<>();
            allnull = true;
            for (TreeNode node : level) {
                lo.add(node);
                if (node != null) {
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                    if (node.left != null || node.right != null) {
                        allnull = false;
                    }
                }
            }
            level = nextLevel;
        } while(!allnull);
        return serList(lo);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<TreeNode> levelOrder = deserList(data);
        if (levelOrder.size() == 0) {
            return null;
        }
        TreeNode root = levelOrder.get(0);
        int parent = 0;
        int child = 1;
        int N = levelOrder.size();
        while(parent < N && child < N) {
            TreeNode p = levelOrder.get(parent);
            if (p != null) {
                if (child < N) {
                    p.left = levelOrder.get(child);
                }
                child++;
                if (child < N) {
                    p.right = levelOrder.get(child);
                }
                child++;
            }
            parent++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

