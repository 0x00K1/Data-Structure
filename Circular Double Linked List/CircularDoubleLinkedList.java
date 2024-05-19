/*        
 		  Node                    Node
	+-------------+         +-------------+    
	| prev | data  <-------> prev | data  <-------> . . - - - - - - + 
	+-------------+         +-------------+                        	|
	^                                                               | 
	|                                                               V	
	+---------------------------------------------------------------+	
*/
public class CircularDoubleLinkedList<E> {
    private Node<E> head = null;   
    private Node<E> tail = null;   
    private int size = 0;          
    
    public CircularDoubleLinkedList() { }
    
    public int size() { return size; }
    public boolean isEmpty() {return (size == 0);}
    
    public E first() {  
        if (isEmpty()) return null;
        return head.getData();  
    }
    
    public E last() {
        if (isEmpty()) return null;
        return tail.getData(); 
    }
    
    public void displayForward() {
        if(isEmpty()){
           System.out.println("\nEmpty List.. ");
           return;
        }
        
        System.out.print("\n********** Display List ***************\n");
        Node<E> current = head;
        int count=1;
        do{
            System.out.println("Node "+count+" :"+current.getData());
            current = current.next;
            count++;
        }while(current!=head); 
        System.out.println("***************************************\n");       
    }
    
    public void displayBackward() {
        if(isEmpty()){
           System.out.println("\nEmpty List.. ");
           return;
        }
        
        System.out.print("\n********** Display List ***************\n");
        Node<E> current = tail;
        int count=1;
        do{
            System.out.println("Node "+count+" :"+current.getData());
            current = current.prev;
            count++;
        }while(current!=tail); 
        System.out.println("***************************************\n");          
    }
    
    public void findNode(E key) {
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }
        
        Node<E> current = head;
        int counter = 1;
        do{  
            if ((current.getData() == key) || ((current.getData()).equals(key))) 
            {
                System.out.println("Found in position# " + counter);
                return;
            }
            
            counter++;
            current = current.next;
        }while(current!=head);
        
        System.out.println("\nNot found...");      
    }

    public void findDuplicate() {
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }

        if (size==1) {
            System.out.println("\nNo duplicates...");
            return;
        }
       
        Node<E> current1 = head;
        boolean flag=false;
        
        do {
            Node<E> current2 = current1.next;
            while (current2 != head) {
                if ((current1.getData() == current2.getData()) || ((current1.getData()).equals(current2.getData()))) 
                {
                    flag=true;
                    System.out.println("Duplicate nodes for " + current1.getData() + ">> " + current2.getData() );
                    break;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        } while (current1 != head);
        
        if (!flag)
            System.out.println("There are no duplicates in the doubly circular linked list...");  
        
    }    
    
    public void addFirst(E data) {
        Node<E> newNode = new Node<E>(data, null,null);
        
        if (isEmpty()) {
            head = tail = newNode;
            newNode.next=head;
            newNode.prev=head;
        }
        else{
            newNode.next=head;
            newNode.prev=tail;            
            head.prev=newNode;
            tail.next=newNode;
            head = newNode;
        }
        size++;

        //System.out.println("\nThe 1st node has been added successfully.. ");        
    }

    public void addLast(E data) { 
        Node<E> newNode = new Node<E>(data, null, null);
        
        if (isEmpty()) {
            head = tail = newNode;
            newNode.next=head;
            newNode.prev=head;
        } 
        else{
            newNode.prev=tail;
            tail.next=newNode;
            head.prev=newNode;
            newNode.next=head;
            tail = newNode;
        }
        size++;
        
        //System.out.println("\nThe last node has been added successfully.. ");       
    }
    
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }
        
        head = head.next;
        tail.next=head;
        head.prev=tail;
        size--;
        System.out.println("\nThe 1st node has been deleted successfully.. ");
        
        if (size == 0) { tail =head = null; }
    }
    
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }
        
        tail = tail.prev;
        head.prev=tail;
        tail.next=head;
        size--;
        System.out.println("\nThe last node has been deleted successfully.. ");
        
        if (size == 0) { tail =head = null; }  
    }   
    
    public void removeNode(E key) {
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }      
        
        Node<E> current = head;
        Node<E> prev = head;
        
        while ( (current.getData() != key) && (!(current.getData()).equals(key)))
        {
            if (current.next == head) {
                System.out.println("\nNot found...");
                return;
            }
            prev = current;
            current = current.next;
        }
        
        if (current == head) {
            removeFirst();
        }
        else if (current == tail) {
            removeLast();
        }
        else
        {
            prev.next = current.next;
            current=current.next;
            current.prev=prev;
            size--;  
            System.out.println("\nThe node has been deleted successfully.. ");
        }
    }
    
    public void addNode(E data, int position) {
        if (position < 1 || position > size+1) {
            System.out.println("\nInvalid Position...");
            return;
        }
        
        if (position == 1) {
            addFirst(data);
            return;
        }
        
        if (position == size+1) {
            addLast(data);
            return;
        }        
        
        Node<E> newNode = new Node<E>(data, null, null);
        Node<E> current = head;
        
        int count = 1;
        while (count < position - 1) {
            current = current.next;
            count++;
        }
        newNode.next=current.next;
        newNode.prev=current;
        
        Node<E> temp=current.next;
        current.next=newNode;
        temp.prev=newNode;
        
        size++;
        System.out.println("\nThe node has been added successfully at position "+position+".. ");
    }
    
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;
        
        Node(E data, Node<E> next, Node<E> prev) {  
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        E getData() { return data;  }
        @SuppressWarnings("unused")
		Node<E> getNext() {  return next;  }
        @SuppressWarnings("unused")
		Node<E> getPrev() {  return prev;  }
        
        @SuppressWarnings("unused")
		void setData(E data) {  this.data = data; }
        @SuppressWarnings("unused")
		void setNext(Node<E> next) { this.next = next; }
        @SuppressWarnings("unused")
		void setPrev(Node<E> prev) { this.prev = prev; }
    }
}