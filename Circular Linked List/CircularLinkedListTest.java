public class CircularLinkedListTest {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        System.out.println("Adding elements to the list...");
        list.addLast(10); // Adding at the end
        list.addFirst(5); // Adding at the beginning
        list.addLast(15); // Adding at the end
        list.display(); // Displaying the list

        System.out.println("\nAdding 20 at position 2...");
        list.addAtPos(20, 2); // Adding 20 at position 2
        list.display(); // Displaying the list

        System.out.println("\nList size: " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());

        System.out.println("\nFinding 20 in the list: " + list.find(20));
        System.out.println("Finding 99 in the list: " + list.find(99)); // Element not in the list

        System.out.println("\nRemoving the first element...");
        list.removeFirst(); // Removing the first element
        list.display(); // Displaying the list

        System.out.println("\nDeleting element 15...");
        list.removeNode(15); // Deleting a specific node
        list.display(); // Displaying the list

        System.out.println("\nRotating the list...");
        list.rotate(); // Rotating the list
        list.display(); // Displaying the list
    }
}