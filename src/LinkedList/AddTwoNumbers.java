package LinkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class AddTwoNumbers {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            }
            int extra = 0;
            ListNode root = new ListNode(0);
            ListNode next = root;
            while (l1 != null || l2 != null) {
                int val = 0;
                if (l1 != null) {
                    val += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    val += l2.val;
                    l2 = l2.next;
                }
                val += extra;
                if (val > 9) {
                    val = val - 10;
                    extra = 1;
                } else {
                    extra = 0;
                }
                ListNode tmp = new ListNode(val);
                next.next = tmp;
                next = tmp;
            }
            if (extra == 1){
                next.next = new ListNode(1);
            }
            return root.next;
        }
    }
}
