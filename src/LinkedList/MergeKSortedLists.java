package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public static void main(String[] args) {

    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeKLists1(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            // 制造一个小顶堆，容量为链表的个数
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
            for (ListNode list : lists) {
                if (list != null) {
                    queue.offer(list);
                }
            }
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            ListNode temp = dummy;
//            dummy.next = temp;
            while (!queue.isEmpty()) {
                temp.next = queue.poll();
                temp = temp.next;
                if (temp.next != null) {
                    queue.offer(temp.next);
                }
            }
            return dummy.next;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            return merge(lists, 0, lists.length - 1);
        }

        // 分治算法
        public ListNode merge(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            }
            int mid = start + (end - start) / 2;
            ListNode left = merge(lists, start, mid);
            ListNode right = merge(lists, mid + 1, end);
            return mergeTwoLists(left, right);
        }

        // 使用递归
        public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
            ListNode p = new ListNode(0);
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                p.next = l1;
                l1.next = mergeTwoLists2(l1.next, l2);
            } else {
                p.next = l2;
                l2.next = mergeTwoLists2(l1, l2.next);
            }
            return p.next;
        }

        // 直接合并
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            while (true) {
                if (l1 == null) {
                    p.next = l2;
                    break;
                }
                if (l2 == null) {
                    p.next = l1;
                    break;
                }
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            return dummy.next;
        }
    }
}
