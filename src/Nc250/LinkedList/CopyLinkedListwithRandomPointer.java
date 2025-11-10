package Nc250.LinkedList;

import java.util.Map;
import java.util.HashMap;

public class CopyLinkedListwithRandomPointer {

    public static void main(String[] args) {
        Node l1 = new Node(3);
        Node l2 = new Node(7);
        Node l3 = new Node(4);
        Node l4 = new Node(5);
        l1.next = l2;

        l2.next = l3;
        l2.random = l4;

        l3.next = l4;
        l3.random = l1;

        l4.random = l2;

        copyRandomList(l1);
    }

    /* Time complexity: O(n)
     * Space complexity: O(n)
     * */
    public static Node copyRandomList(Node head) {
        // Map to store mapping between original node → its copied node
        Map<Node, Node> oldToCopyNodeMap = new HashMap<>();
        Node current = head;

        // First pass: create a copy of each node and store it in the map
        while (current != null) {
            Node copy = new Node(current.val); // Create a new node with the same value
            oldToCopyNodeMap.put(current, copy); // Map original node to its copy
            current = current.next; // Move to the next original node
        }

        // Second pass: assign next and random pointers for each copied node
        current = head;
        while (current != null) {
            Node copy = oldToCopyNodeMap.get(current); // Get the copy of the current node

            // Set the next pointer of the copied node
            copy.next = oldToCopyNodeMap.get(current.next);

            // Set the random pointer of the copied node
            copy.random = oldToCopyNodeMap.get(current.random);

            current = current.next; // Move to the next original node
        }

        // Return the copied version of the head node
        return oldToCopyNodeMap.get(head);
    }
}
