package SinglyLL;

// LINKED LIST IMPLEMENTATION
public class LL {
    private Node head; // Pointer to the first node
    private Node tail; // Pointer to the last node
    private int size;  // Keeps track of the number of elements

    public LL() {
        this.size = 0;
    }  // Initial state: empty list

    // NODE CLASS - Building blocks of the linked list
    private class Node {
        private int data;   // Value storage
        private Node next; // Pointer to next node

        public Node(int data) {  // Constructor for end nodes
            this.data = data;
            this.next = null;   // Default: no next node
        }

        public Node(int data, Node next) {  // Constructor for middle nodes
            this.data = data;
            this.next = next;  // Connect to existing node
        }
    }

    // ================= CORE METHODS ================= //

    // Insert at beginning ⚡ O(1)
    public void insertFirst(int data) {
        Node newNode = new Node(data);  // Create node
        newNode.next = head;  // New node points to old head
        head = newNode;       // Update head to new node

        if (tail == null) {   // First node in empty list
            tail = head;      // Head and tail same
        }
        size++;  // Track size
    }

    // Add to end 🏁 O(1) with tail reference
    public void add(int a) {
        if (tail == null) {  // Empty list
            insertFirst(a);  // Use existing method
            return;
        }
        Node node = new Node(a);  // Create new node
        tail.next = node;    // Current tail points to new node
        tail = node;         // Update tail to new node
        size++;
    }

    // Insert at specific index 🎯 O(n)
    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }  // Edge case: start
        if (index == size) {
            add(val);
            return;
        }   // Edge case: end

        // Find insertion point
        Node temp = head;
        // Traverse to node BEFORE target index
        for (int i = 1; i < index; i++) {  // Start from 1 to do (index-1) jumps
            temp = temp.next;
        }
        /* Visualization for index 2 insertion:
           Start: [1] → [2] → [3]
           After loop: temp = [2]
           New node: [99] → [3]
           Result: [1] → [2] → [99] → [3] */

        Node node = new Node(val, temp.next);  // Create node pointing to next
        temp.next = node;     // Insert between temp and next node
        size++;
    }

    // Delete first node 🗑️ O(1)
    public int deleteFirst() {
        int val = head.data;  // Save value to return
        head = head.next;     // Move head pointer forward

        if (head == null) {   // List became empty
            tail = null;      // Clear tail reference
        }
        size--;
        return val;
    }

    // Delete last node 🔚 O(n) without double linked list
    public int deleteLast() {
        if (size <= 1) {  // Handle 0 or 1 node cases
            return deleteFirst();
        }

        Node secondLast = getNode(size - 2);  // Get node before tail
        int val = tail.data;    // Save last value
        tail = secondLast;      // Update tail
        tail.next = null;      // Sever connection
        size--;
        return val;
    }

    // Delete by index 🎯 O(n)
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }  // Edge case

        Node prev = head;
        // Find node BEFORE target index
        for (int i = 0; i < index - 1; i++) {  // Different loop style, same result
            prev = prev.next;
        }

        Node toDelete = prev.next;    // Target node
        prev.next = toDelete.next;    // Bypass target node

        if (toDelete == tail) {       // If deleting last node
            tail = prev;              // Update tail
        }
        size--;
        return toDelete.data;
    }

    // ================= HELPER METHODS ================= //

    // Get node at specific index 🔍 O(n)
    public Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {  // Simple traversal
            node = node.next;
        }
        return node;
    }

    // Find node by value 🔎 O(n)
    public Node findNode(int value) {
        Node temp = head;
        while (temp != null) {  // Fixed: previously used head.next (bug!)
            if (temp.data == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;  // Value not found
    }

    // Display list contents 🖨
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}