package Lecture;

class LinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;        
	
    // Access methods . .
	
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getData();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getData();
    }

    public void display() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("NULL");
    }

    public boolean find(E e) {
        Node<E> current = head;
        while (current != null) {
            if (current.getData().equals(e)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Update methods . .
    
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public void addAtPos(E value, int pos) {
        if (pos == 1) {
            addFirst(value);
            return;
        }

        Node<E> newNode = new Node<>(value, null);
        Node<E> current = head;
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
    
    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getData();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }
    
    public void deleteNode(E value) {
        Node<E> current = head;
        Node<E> previous = null;

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
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

	private static class Node<E> {
		/*	      Node		      Node
			+-------------+         +-------------+    
			| data | next - - - - - > data | next - - - - - > . . - - - - - > NULL
			+-------------+         +-------------+ 
		*/
		private E data;
		private Node<E> next;
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
		
		public E getData() {
			return data;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
}
