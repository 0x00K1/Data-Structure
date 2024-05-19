/*        
 		  Node                    Node
	+-------------+         +-------------+    
	| data | next - - - - - > data | next - - - - - > . . - - - - - +
	+-------------+         +-------------+                        	|
	^                                                              	|
	|                                                              	V	
	+---------------------------------------------------------------+
*/
public class CircularLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public CircularLinkedList() {
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
	
	public void display() {
		if(isEmpty()) { System.out.println("Empty List!!"); return; }
        Node<T> current = head;
        do {
        	System.out.print(current.getData() + " -> ");
            current = current.getNext();
        } while(current != head);
        System.out.println("Restart");
    }

    public boolean find(T e) {
		if(isEmpty()) { System.out.println("Empty List!!"); return false; }
        Node<T> current = head;
        do {
        	if(current.getData().equals(e)) {
        		return true;
        	}
        	current = current.getNext();
        } while(current != head);
        return false;
    }
    
    public void addFirst(T value) {
        Node<T> head = new Node<>(value, null);
        head.next = this.head;
        this.head = head;
        if (size == 0) { tail = this.head;}
        tail.next = this.head;
        size++;
    }

    public void addLast(T value) {
       Node<T> tail = new Node<>(value, null);
       if (size == 0) { 
	       head = this.tail = tail;
       } else {
    	   this.tail.next = tail;
	       this.tail = tail;
       }
       tail.next = head;
       size++;
    }

    public void addAtPos(T value, int pos) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            addFirst(value);
            return;
        } else if (pos == size + 1) {
            addLast(value);
            return;
        } else {
            Node<T> newNode = new Node<>(value, null);
            Node<T> current = head;
            int count = 1;

            while (count < pos - 1) {
                current = current.getNext();
                count++;
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
        }
    }
    
    public void removeFirst() {
		if(isEmpty()) { System.out.println("Empty List!!"); return; }
		head = head.next;
        tail.next = head;
        size--;
        if(size == 0) { head=tail=null; }
    }
    
    public void removeNode(T value) {
		if(isEmpty()) { System.out.println("Empty List!!"); return; }
		if(head.getData() == value) { removeFirst(); return; }
        Node<T> current = head, previous = head;
        while(current.getData() != value) {
        	if(current.next == head) { 
        		System.out.println("Value Not Found!!"); return; 
        	} else {
        		previous = current; 
        		current = current.next;
        	}
        }
        previous.next = current.next;
        size--;
    }
    
    public void rotate() {
        if (!isEmpty()) {
            head = head.next; 
            tail= tail.next;
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