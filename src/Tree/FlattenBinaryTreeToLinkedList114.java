package Tree;

public class FlattenBinaryTreeToLinkedList114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);
            TreeNode tmp = root.right;
            root.right = root.left;
            TreeNode n = root.right;
            while (n != null) {
                n = n.right;
            }
            n.right = tmp;
        }

    }

}
