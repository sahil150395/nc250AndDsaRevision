package Nc250.LinkedList;

public class RemoveNodeFromEndofLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println(removeNthFromEnd(l1, 6).toString());
    }

    /*
     * Time complexity: O(L) - L is the number of the nodes in the linked list
     * Space complexity: O(1)
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i++;
        }

        if(fast == null) {
            return head.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return head;
        */


        // Step 1: Create a dummy node and point it to the head
        // This helps handle cases where the head itself needs to be removed.
        // we move fastPointer one step after slow so we are at a node one before the node to be deleted
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Initialize slow pointer at the dummy and fast at head
        ListNode fast = head;
        ListNode slow = dummy;

        // Step 3: Move the 'fast' pointer n steps ahead
        // This keeps a gap of n nodes between fast and slow.
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Step 4: Move both pointers one step at a time until fast reaches the end
        // At this point, slow will be right before the node we need to delete.
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 5: Skip the target node (the nth node from the end)
        slow.next = slow.next.next;

        // Step 6: Return the real head (dummy.next)
        return dummy.next;
    }
}
