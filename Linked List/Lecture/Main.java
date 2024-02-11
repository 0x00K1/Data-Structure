// Demonstrates various operations on a custom LinkedList implementation.
package Lecture;

public class Main {
	public static void main(String[] args) {
	// LinkedList list = new LinkedList(); // Generic object list, accept any data type.
        LinkedList<String> list = new LinkedList<>(); // String object list, for providing type safety.
		
        // Add elements
        System.out.println("Adding elements to the list...");
        list.addLast("A");
        list.addLast("B");
        list.addFirst("C");
        list.display();

        // Add element at position
        System.out.println("\nAdding element at position 2...");
        list.addAtPos("D", 2);
        list.display();

        // Now use the traverse method to print each element on a new line
        System.out.println("\nTraversing the list:");
        list.traverse();
        
        // Size of the list
        System.out.println("\nSize of the list: " + list.size());

        // Check if the list contains an element
        System.out.println("\nChecking if the list contains 'A': " + list.find("A"));
        System.out.println("Checking if the list contains 'Z': " + list.find("Z"));

        // Remove first element
        System.out.println("\nRemoving the first element...");
        list.removeFirst();
        list.display();

        // Delete a specific node
        System.out.println("\nDeleting node with value 'A'...");
        list.deleteNode("A");
        list.display();

        // Access first and last element
        System.out.println("\nFirst element: " + list.first());
        System.out.println("Last element: " + list.last());

        // Check if the list is empty
        System.out.println("\nIs the list empty? " + list.isEmpty());

        // Clearing the list
        System.out.println("\nClearing the list...");
        while (!list.isEmpty()) {
            list.removeFirst();
        }
        list.display();
        System.out.println("Is the list empty? " + list.isEmpty());
	}
}
