package StackAndQueue;

/**
 * https://leetcode.com/problems/min-stack/
 * #155
 * 思路:
 * 每个head保存当时的最小值, 新push时, 比较当时的值和已存的值, HEAD的min取最小的那个
 */
public class MinStack {
    private Node head;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        head = null;
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
            return;
        }
        head = new Node(x, minValue(x, head.min), head);
    }

    public void pop() {
        if (head == null){
            return;
        }
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private int minValue(int a, int b) {
        return a > b ? b : a;
    }

    /**
     * Definition for singly-linked list.
     */
    class Node {
        int val;
        Node next;
        int min;

        Node(int x, int m, Node n) {
            val = x;
            min = m;
            next = n;
        }
    }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */