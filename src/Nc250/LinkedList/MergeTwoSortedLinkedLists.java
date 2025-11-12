package Nc250.LinkedList;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        ListNode l1node1 = new ListNode(1);
        ListNode l1node2 = new ListNode(2);
        ListNode l1node3 = new ListNode(4);
        ListNode l2node1 = new ListNode(1);
        ListNode l2node2 = new ListNode(3);
        ListNode l2node3 = new ListNode(5);
        l1node1.next = l1node2;
        l1node2.next = l1node3;
        l2node1.next = l2node2;
        l2node2.next = l2node3;

        mergeTwoLists(l1node1, l2node1);
    }

    /*
     * Time complexity: O(m+n),  m is the number of elements in list1, n is the number of elements in list2
     * Space complexity: O(1)
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*ListNode head, current;

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.getVal() < list2.getVal()) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        current = head;

        while (list1 != null && list2 != null) {
            if (list1.getVal() < list2.getVal()) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        while (list1 != null) {
            current.next = list1;
            list1 = list1.next;
            current = current.next;
        }

        while (list2 != null) {
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }

        return head;*/

        // Create a dummy node to simplify list handling
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Merge the two lists
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach whatever remains (only one of them will be non-null)
        current.next = (list1 != null) ? list1 : list2;

        // Return the real head (skip the dummy)
        return dummy.next;
    }

}

