package SinglyLL;

// MAIN CLASS - Testing the LinkedList
public class Main {
    public static void main(String[] args) {
        LL ll = new LL();  // Create empty linked list
        int[] arr = {1,2,3,4,5};  // Initial values

        // Populate linked list with array values
        for (int i = 0; i < arr.length; i++) {
            ll.add(arr[i]);  // Add to end of list
        }

        // OPERATIONS SEQUENCE
        System.out.println("+++++++++++++++");
        ll.display();  // Show initial list: 1→2→3→4→5→null

        ll.insert(99, 2);  // Insert 99 at index 2
        ll.deleteLast();    // Remove last node (5)
        ll.display();       // Now: 1→2→99→3→4→null

        ll.delete(2);       // Remove index 2 (99)
        ll.display();       // Final: 1→2→3→4→null
        System.out.println("+++++++++++++++");
    }
}