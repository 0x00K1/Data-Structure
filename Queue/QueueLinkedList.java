public class QueueLinkedList<E> {
    //Nested Node inner-class:
    private static class Node<E> {
        private E data;            
        private Node<E> next;      
        
        Node(E data, Node<E> next) {  
            this.data = data;
            this.next = next;
        }//end of Node constructor

        @SuppressWarnings("unused")
		E getData() { return data;  }
        @SuppressWarnings("unused")
		Node<E> getNext() {  return next;  }
        
        @SuppressWarnings("unused")
		void setData(E data) {  this.data = data; }
        @SuppressWarnings("unused")
		void setNext(Node<E> next) { this.next = next; }
        
        public String toString(){return data+"";} //to enable printing data after calling getFront or deQueue cause E is not recognizable
    }//end of Node class
    
    private Node<E> front=null, rear=null;
    private int size=0;

    public QueueLinkedList() { }
    
    public boolean isEmpty(){return size==0;}
    public int size() {return size;}
    
    public Node<E> getFront() { 
        if (isEmpty()) return null;
        return front;
    }//end of getFront
    
    public Node<E> getRear() { 
        if (isEmpty()) return null;
        return rear;
    }//end of getRear    
    
    
public void enQueue(E value){  //like addLast in a LL
        @SuppressWarnings({ "rawtypes", "unchecked" })
		Node<E> newNode = new Node(value, null);
        if (size == 0)
        { 
           front = newNode; 
           rear = newNode; 
        }
        else{
           rear.next = newNode;
           rear = newNode;
        }//end if
        size++;
        System.out.println(value + " - Added to Queue");
    }//end of enQueue
    
    public Node<E> deQueue() {  //like removeFirst in a LL
        if (isEmpty()) {
            System.out.println("\nERROR: Queue Underflow!");
            return null;
        }//end if
        
        Node<E> temp=front;
        front = front.next;
        size--;   
        if (size == 0) { rear = null; }       
        System.out.println(temp.data + "- Deleted from Queue");        
        return temp;
    }//end of deQueue
    
    public void display(){        
        if (isEmpty()) {
            System.out.println("\nERROR: Empty Queue!");
            return;
        }//end if          
        System.out.print("\n********** Display Queue **************\n");
        
        Node<E> current=front;
        while(current!=null)
        {
            System.out.println(current.data);
            current=current.next;
        }//end loop        
        System.out.println("***************************************\n"); 
    }//end of display 
}//end of class
