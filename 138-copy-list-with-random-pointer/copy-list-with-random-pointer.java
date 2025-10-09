/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
          if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // First pass: create all nodes
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: assign next and random
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);     // could be null
            map.get(curr).random = map.get(curr.random); // could be null
            curr = curr.next;
        }

        return map.get(head);
    }
}