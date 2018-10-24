package LinkedList;

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
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            ListNode node = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return head;
        }
    }

    class IterativeSolution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode currentNode = head;
            ListNode prevNode = null;
            while (currentNode.next != null) {
                ListNode nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
            }
            currentNode.next = prevNode;
            return currentNode;
        }
    }

}

