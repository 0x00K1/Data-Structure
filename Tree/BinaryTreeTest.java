public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        
        // Inserting elements to create a full binary tree
        bt.insert(50);
        bt.insert(30);
        bt.insert(70);
        bt.insert(20);
        bt.insert(40);
        bt.insert(60);
        bt.insert(80);

        System.out.println("In-order traversal of the full binary tree:");
        bt.inOrder(bt.getRoot());

        System.out.println("Pre-order traversal of the full binary tree:");
        bt.preOrder(bt.getRoot());

        System.out.println("Post-order traversal of the full binary tree:");
        bt.postOrder(bt.getRoot());

        System.out.println("\nDepth of the root node: " + bt.depth(bt.getRoot()));
        System.out.println("Height of the tree: " + bt.height(bt.getRoot()));

        // Test finding min and max values
        System.out.println("Minimum value in the tree: " + bt.findMin(bt.getRoot()).getValue());
        System.out.println("Maximum value in the tree: " + bt.findMax(bt.getRoot()).getValue());

        // Test deleting a node
        bt.delete(bt.getRoot(), 20);
        System.out.println("In-order traversal after deleting node 20:");
        bt.inOrder(bt.getRoot());

        // Test deleting the smallest element
        bt.deleteSmallestElement();
        System.out.println("In-order traversal after deleting the smallest element:");
        bt.inOrder(bt.getRoot());
        
        System.out.println("\nBST size: " + bt.getSize());
    }
}