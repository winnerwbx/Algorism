package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 * #225
 */
public class ImplementStackUsingQueues {
    class MyStack {
        private Queue<Integer> queue = new ArrayDeque<>();
        private int size = 0;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
            if (!queue.isEmpty()) {
                for (int i = 0; i < size; i++) {
                    queue.add(queue.remove());
                }
            }
            size++;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.remove();
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (!queue.isEmpty())
                return queue.peek();
            else return 0;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /*
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}
