package LinkedList;

/**
 * @author wangboxuan <wangboxuan@kuaishou.com>
 * @date 2022/08/04
 */
public class RemoveDupFromSortedList_83 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode left = head;
            ListNode right = head.next;
            while (right != null) {
                if (right.val == left.val) {
                    right = right.next;
                    left.next = right;
                } else {
                    left = left.next;
                    right = left.next;
                }
            }
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
