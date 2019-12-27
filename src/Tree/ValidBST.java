package Tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidBST {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        private boolean helper(TreeNode root, Integer upper, Integer lower) {
            if (root == null) {
                return true;
            }
            if (upper != null && root.val >= upper) {
                return false;
            }
            if (lower != null && root.val <= lower) {
                return false;
            }
            return helper(root.left, root.val, lower) && helper(root.right, upper, root.val);
        }

        // 中序遍历
        public boolean isValidBST2(TreeNode root) {
            if (root == null) {
                return true;
            }
            int tmp = Integer.MIN_VALUE;
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.val <= tmp){
                    return false;
                }
                tmp = root.val;
                root = root.right;
            }
            return true;
        }
    }
}
