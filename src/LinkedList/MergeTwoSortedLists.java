package LinkedList;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * #21
 */
public class MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            // Add stub node
            ListNode l3 = new ListNode(0);
            ListNode currentNode = l3;
            while (true) {
                if (l1.val < l2.val) {
                    currentNode.next = l1;
                    l1 = l1.next;
                } else {
                    currentNode.next = l2;
                    l2 = l2.next;
                }
                currentNode = currentNode.next;
                if (l1 == null) {
                    currentNode.next = l2;
                    break;
                }
                if (l2 == null) {
                    currentNode.next = l1;
                    break;
                }
            }
            return l3.next;
        }
    }
}
