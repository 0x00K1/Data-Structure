/*	   
		  Node					  Node
	+-------------+         +-------------+    
	| data | next - - - - - > data | next - - - - - > . . - - - - - > NULL
	+-------------+         +-------------+ 
*/
class SingleLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;        
		
	public SingleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if (isEmpty()) return null;
        return head.getData();
    }

    public T last() {
        if (isEmpty()) return null;
        return tail.getData();
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("NULL");
    }

    public int find(T e) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.getData().equals(e)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;  // Return -1 if the element is not found
    }
    
    public void addFirst(T e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T e) {
        Node<T> newNode = new Node<>(e, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public void addAtPos(T value, int pos) {
        if (pos == 1) {
            addFirst(value);
            return;
        }

        Node<T> newNode = new Node<>(value, null);
        Node<T> current = head;
        int count = 1;

        while (current != null && count < pos - 1) {
            current = current.getNext();
            count++;
        }

        if (current == null) {
            System.out.println("Position exceeds the list size");
            return;
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }
    
    public T removeFirst() {
        if (isEmpty()) return null;
        T answer = head.getData();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }
    
    public void deleteNode(T value) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null && !current.getData().equals(value)) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            System.out.println("Value doesn't exist");
            return;
        }

        if (previous == null) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            previous.setNext(current.getNext());
            if (current == tail) {
                tail = previous;
            }
        }
        size--;
    }
    
    public void traverse() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		public T getData() {
			return this.data;
		}
		
		public Node<T> getNext(){
			return this.next;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
}