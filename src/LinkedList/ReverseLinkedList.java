package LinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * #206
 */
public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class RecursiveSolution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode result = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return result;
        }
    }

    class IterativeSolution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode currentNode = head;
            ListNode prevNode = null;
            while (currentNode != null) {
                ListNode nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
            }
            return prevNode;
        }
    }

}

