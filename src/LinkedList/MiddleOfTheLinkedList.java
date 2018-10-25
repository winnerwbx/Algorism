package LinkedList;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * #876
 */
public class MiddleOfTheLinkedList {
    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode ahead = dummy;
            ListNode behind = dummy;
            while (behind != null) {
                ahead = ahead.next;
                if (behind.next == null) {
                    break;
                }
                behind = behind.next.next;
            }
            return ahead;
        }
    }

}
