public class SingleLinkedListTest {
	public static void main(String[] args) {
		// LinkedList list = new LinkedList(); // Generic object list, accept any data type.
		SingleLinkedList<String> list = new SingleLinkedList<>(); // String object list, for providing type safety.
		
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

        // Index of element
        int indexA = list.find("A");
        if (indexA != -1) {
            System.out.println("\nIndex of 'A': " + indexA);
        } else {
            System.out.println("\n'A' not found in the list");
        }
        int indexZ = list.find("Z");
        if (indexZ != -1) {
            System.out.println("Index of 'Z': " + indexZ);
        } else {
            System.out.println("'Z' not found in the list");
        }
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
        
        // Display the list
        System.out.println("\nDisplay the list:");
        list.display();
        
        System.out.println("\nIs the list empty? " + list.isEmpty());
	}
}