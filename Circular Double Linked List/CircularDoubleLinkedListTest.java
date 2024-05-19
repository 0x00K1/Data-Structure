public class CircularDoubleLinkedListTest {
    public static void main(String[] args) {
        CircularDoubleLinkedList<Integer> list = new CircularDoubleLinkedList<>();

        // Test addFirst method
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println("After adding nodes at the beginning:");
        list.displayForward();

        // Test addLast method
        list.addLast(40);
        list.addLast(50);
        System.out.println("After adding nodes at the end:");
        list.displayForward();

        // Test size method
        System.out.println("Size of the list: " + list.size());

        // Test first and last methods
        System.out.println("First element: " + list.first());
        System.out.println("Last element: " + list.last());

        // Test findNode method
        list.findNode(20);  // Should be found
        list.findNode(60);  // Should not be found

        // Test findDuplicate method
        list.addLast(10);
        list.findDuplicate();

        // Test removeFirst method
        list.removeFirst();
        System.out.println("After removing the first node:");
        list.displayForward();

        // Test removeLast method
        list.removeLast();
        System.out.println("After removing the last node:");
        list.displayForward();

        // Test removeNode method
        list.removeNode(20);
        System.out.println("After removing a specific node (20):");
        list.displayForward();

        // Test addNode method
        list.addNode(25, 2);
        System.out.println("After adding a node at position 2:");
        list.displayForward();

        // Test displayBackward method
        System.out.println("Display list backward:");
        list.displayBackward();
    }
}