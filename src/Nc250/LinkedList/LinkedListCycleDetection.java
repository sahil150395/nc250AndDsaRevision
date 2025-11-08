package Nc250.LinkedList;

public class LinkedListCycleDetection {

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
        l6.next = l3;

        System.out.println(hasCycle(l1));
    }

    /*
     * 1. Using Floyd's Cycle-Finding Algorithm
     * 2. hare and tortoise algorithm
     * 3. Maintain two pointers one slow and one fast
     * 4. The slow pointer increments by one and the fast pointer increments by two
     * 5. If the slow and fast pointer meet means there is a cycle
     * 6. We are guaranteed that both the pointer meet is because with each iteration the distance between
     * the two pointers reduces and they finally meet
     * 7. If our linked list has a cycle, our fast pointer will eventually catch
     * up to the slow pointer as it will never become null.
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public static boolean hasCycle(ListNode head) {

        ListNode slowPointer = head, fastPointer = head;

        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
}
