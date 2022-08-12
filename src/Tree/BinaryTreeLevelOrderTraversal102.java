package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> q = new ArrayDeque<>();
            List<List<Integer>> result = new ArrayList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> curLevel = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode n = q.poll();
                    curLevel.add(n.val);
                    if (n.left != null) {
                        q.offer(n.left);
                    }
                    if (n.right != null) {
                        q.offer(n.right);
                    }
                }
                result.add(curLevel);
            }
            return result;
        }
    }

}
