package StackAndQueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * #232
 * 思路:
 * 使用两个Stack, 一个正序一个逆序
 */
public class ImplementQueueUsingStacks {
    class MyQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return stack1.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack1.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.empty();
        }
    }

    class MyQueue2 {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int front;

        /**
         * Initialize your data structure here.
         */
        public MyQueue2() {
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (stack1.empty()) {
                front = x;
            }
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (stack2.empty()) {
                return front;
            } else {
                return stack2.peek();
            }
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.empty() && stack2.empty();
        }
    }

}
