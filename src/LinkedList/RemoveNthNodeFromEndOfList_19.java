package LinkedList;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * Follow up: Could you do this in one pass?
 * <p>
 * Related Topics
 * 链表
 * 双指针
 */
public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode a = p;
        ListNode b = p;
        for (int i = 0; i < n; i++) {
            b = b.next;
        }
        while (true) {
            if (b == null) {
                return null;
            }
            if (b.next != null) {
                b = b.next;
                a = a.next;
            }
            if (b.next == null) {
                break;
            }
        }
        a.next = a.next.next;
        return p.next;
    }
}
