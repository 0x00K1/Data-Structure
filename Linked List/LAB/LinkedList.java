package LAB;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, head);
        head = newNode;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addNode(T data, int pos) {
        if (pos == 1) {
            addFirst(data);
            return;
        }
        Node<T> newNode = new Node<>(data, null);
        Node<T> current = head;
        for (int i = 1; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new RuntimeException("Cannot remove from an empty list");
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    public int findNode(T data) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void removeNode(T data) {
        if (head == null) throw new RuntimeException("Cannot remove from an empty list");
        if (head.data.equals(data)) {
            removeFirst();
            return;
        }
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Value doesn't exist");
            return;
        }
        previous.next = current.next;
        size--;
        if (current == tail) {
            tail = previous;
        }
    }
    
    private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
}