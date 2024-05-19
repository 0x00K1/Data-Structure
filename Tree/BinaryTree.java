public class BinaryTree  {

    class BinaryTreeNode {
        private int value;
        private BinaryTreeNode parent;
        private BinaryTreeNode leftChild;
        private BinaryTreeNode rightChild;

        public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild, BinaryTreeNode parent) {
            this.value = value;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        // Getters and Setters
        public int getValue() {
            return value;
        }

        public BinaryTreeNode getParent() {
            return parent;
        }

        public BinaryTreeNode getLeftChild() {
            return leftChild;
        }

        public BinaryTreeNode getRightChild() {
            return rightChild;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setParent(BinaryTreeNode parent) {
            this.parent = parent;
        }

        public void setLeftChild(BinaryTreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(BinaryTreeNode rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    private BinaryTreeNode root = null;
    private int size = 0;

    public Q3_Qs1() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public BinaryTreeNode getRoot() {
        if (isEmpty()) return null;
        return root;
    }

    public void insert(int value) {
        BinaryTreeNode newNode = new BinaryTreeNode(value, null, null, null);

        if (isEmpty()) {
            root = newNode;
            size++;
            System.out.println(value + " - Added to Binary Search Tree");
            return;
        }

        BinaryTreeNode current = root;
        BinaryTreeNode parent;

        while (true) {
            parent = current;
            if (value == current.value) {
                System.out.println(">> Duplicate Found!");
                return;
            } else if (value < current.value) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    break;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    break;
                }
            }
        }

        newNode.parent = parent;
        size++;
        System.out.println(value + " - Added to Binary Search Tree");
    }

    public void delete(BinaryTreeNode node, int value) {
        BinaryTreeNode current = find(node, value);

        if (current == null) {
            System.out.println("Not Found!");
            return;
        }

        // Case 1: Node to be deleted is a leaf node
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else {
                if (current.parent.leftChild == current) {
                    current.parent.leftChild = null;
                } else {
                    current.parent.rightChild = null;
                }
            }
        }
        // Case 2: Node to be deleted has one child
        else if (current.leftChild == null || current.rightChild == null) {
            BinaryTreeNode child = (current.leftChild != null) ? current.leftChild : current.rightChild;

            if (current == root) {
                root = child;
            } else {
                if (current.parent.leftChild == current) {
                    current.parent.leftChild = child;
                } else {
                    current.parent.rightChild = child;
                }
            }
            child.parent = current.parent;
        }
        // Case 3: Node to be deleted has two children
        else {
            BinaryTreeNode minNode = findMin(current.rightChild);
            current.value = minNode.value;
            delete(minNode, minNode.value); // Recursively delete the inorder successor
        }
        size--;
    }

    public BinaryTreeNode find(BinaryTreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (node.value == value)
            return node;

        if (value < node.value)
            return find(node.leftChild, value);
        else
            return find(node.rightChild, value);
    }

    public BinaryTreeNode findMin(BinaryTreeNode node) {
        while (node.leftChild != null)
            node = node.leftChild;

        return node;
    }

    public BinaryTreeNode findMax(BinaryTreeNode node) {
        while (node.rightChild != null)
            node = node.rightChild;

        return node;
    }

    public void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.println(node.value);
            inOrder(node.rightChild);
        }
    }

    public void preOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.value);
        }
    }

    public int depth(BinaryTreeNode node) {
        if (isEmpty()) {
            System.out.println("ERROR: Empty Tree!");
            return 0;
        }

        if (node == root)
            return 0;
        else
            return 1 + depth(node.parent);
    }

    public int height(BinaryTreeNode node) {
        int h = 0;
        if (node != null)
            h = Math.max(depth(node), Math.max(height(node.leftChild), height(node.rightChild)));
        return h;
    }
}