package Nc250.LinkedList;

public class MyCircularQueue {

    int capacity;
    ListNode left;
    ListNode right;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.left = new ListNode(0);
        this.right = this.left;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        ListNode current = new ListNode(value);
        if (isEmpty()) {
            this.left.next = current;
            this.right = current;
        } else {
            this.right.next = current;
            this.right = current;
        }

        this.capacity--;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;

        this.left.next = this.left.next.next;
        if (this.left.next == null) {
            this.right = this.left;
        }

        this.capacity++;
        return true;
    }


    public int Front() {
        return isEmpty() ? -1 : this.left.next.val;
    }

    public int Rear() {
        return isEmpty() ? -1 : this.right.val;
    }

    public boolean isEmpty() {
        return this.left.next == null;
    }

    public boolean isFull() {
        return this.capacity == 0;
    }

}
