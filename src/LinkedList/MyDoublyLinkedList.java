package LinkedList;

/**
 * https://leetcode.com/problems/design-linked-list/
 * #707
 */
class MyDoublyLinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyDoublyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            if (currentNode != null) {
                currentNode = currentNode.next;
            } else {
                return -1;
            }
        }
        if (currentNode != null) {
            return currentNode.val;
        } else {
            return -1;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        head = new Node(val, head, null);
        if (size == 0) {
            tail = head;
            size = 1;
            return;
        }
        head.next.prev = head;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        tail = new Node(val, null, tail);
        if (size == 0) {
            head = tail;
            size = 1;
            return;
        }
        tail.prev.next = tail;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node currentNode = head;
        for (int i = 1; i < index; i++) {
            if (currentNode != null) {
                currentNode = currentNode.next;
            } else {
                return;
            }
        }
        if (currentNode != null) {
            Node toBeInserted = new Node(val, currentNode.next, currentNode);
            currentNode.next = toBeInserted;
            toBeInserted.next.prev = toBeInserted;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size || head == null) {
            return;
        }
        if (size == 1 && index == 0) {
            head = tail = null;
            size = 0;
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            if (currentNode != null) {
                currentNode = currentNode.next;
            } else {
                return;
            }
        }
        if (currentNode == null) {
            return;
        }
        if (currentNode.prev != null) {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}

/**
 * Your LinkedList.MySinglyLinkedList object will be instantiated and called as such:
 * LinkedList.MySinglyLinkedList obj = new LinkedList.MySinglyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */