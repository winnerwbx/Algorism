package LinkedList;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list
 * #19
 */
public class RemoveNthNodeFromEndOfList {
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

    /**
     * 思路
     * 如果知道链表的长度，就可以从前往后一次遍历就可以了。但是求链表长度还需要遍历一次，因此总共需要两次遍历。
     * 题目要求使用一次遍历，可以使用两个指针来实现。
     * 初始都指向 head，第一个指针前进 N 步，然后两个指针同时前进直到第一个指针到达链表末尾，第二个指针后面的那个节点就是要移除的节点。
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head.next == null) {
                return null;
            }
            ListNode ahead = head;
            ListNode behind = head;
            ListNode preBehind = null;
            for (int a = 1; a < n; a++) {
                ahead = ahead.next;
            }
            while (ahead.next != null) {
                ahead = ahead.next;
                preBehind = behind;
                behind = behind.next;
            }
            // To remove the 1st node
            if (preBehind == null) {
                return head.next;
            }
            preBehind.next = behind.next;
            return head;
        }
    }
}
