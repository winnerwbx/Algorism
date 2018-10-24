class MySinglyLinkedList {
    private Node head = null;

    /**
     * Initialize your data structure here.
     */
    public MySinglyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
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
        this.head = new Node(val, head);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(val, null);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
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
            currentNode.next = new Node(val, currentNode.next);
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     * NOTICE: when delete at index 0, should update head
     */
    public void deleteAtIndex(int index) {
        if (head != null && index == 0){
            head = head.next;
            return;
        }
        Node prevNode = null;
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            if (currentNode != null) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            } else {
                return;
            }
        }
        if (prevNode == null) {
            return;
        }
        if (currentNode != null) {
            prevNode.next = currentNode.next;
        } else {
            prevNode.next = null;
        }
    }

    class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MySinglyLinkedList object will be instantiated and called as such:
 * MySinglyLinkedList obj = new MySinglyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */