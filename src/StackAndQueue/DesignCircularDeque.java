package StackAndQueue;

/**
 * https://leetcode.com/problems/design-circular-deque/
 * 循环双端队列
 * Design your implementation of the circular double-ended queue (deque).
 * <p>
 * Your implementation should support following operations:
 * <p>
 * MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
 * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
 * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
 * getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
 * getRear(): Gets the last item from Deque. If the deque is empty, return -1.
 * isEmpty(): Checks whether Deque is empty or not.
 * isFull(): Checks whether Deque is full or not.
 * <p>
 * <p>
 * Example:
 * <p>
 * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
 * circularDeque.insertLast(1);			// return true
 * circularDeque.insertLast(2);			// return true
 * circularDeque.insertFront(3);			// return true
 * circularDeque.insertFront(4);			// return false, the queue is full
 * circularDeque.getRear();  			// return 2
 * circularDeque.isFull();				// return true
 * circularDeque.deleteLast();			// return true
 * circularDeque.insertFront(4);			// return true
 * circularDeque.getFront();			// return 4
 * <p>
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Deque library.
 */
public class DesignCircularDeque {
    class MyCircularDeque {
        int[] queue;
        int left = 0, right = 0;
        int length;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            queue = new int[k + 1];
            length = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            left = left == 0 ? length : left - 1;
            queue[left] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            queue[right] = value;
            right = right == length ? 0 : right + 1;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            left = left == length ? 0 : left + 1;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            right = right == 0 ? length : right - 1;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()){
                return -1;
            }
            return queue[left];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()){
                return -1;
            }
            return queue[right == 0 ? length : right - 1];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return left == right;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return left - right == 1 || right - left == length;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
