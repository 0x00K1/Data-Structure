public class QueueDoubleEnded<E> {
   //Nested Node inner-class:
    private static class Node<E> {
        private E data;            
        private Node<E> next;      
        private Node<E> prev;      
        
        Node(E data, Node<E> next, Node<E> prev) {  
            this.data = data;
            this.next = next;
            this.prev = prev;
        }//end of Node constructor

        @SuppressWarnings("unused")
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
        
        public String toString(){return data+"";} 
    }//end of Node class
    //--------------------------------------------------
    
    //Attributes    
    private Node<E> front=null, rear=null;
    private int size=0;

    public QueueDoubleEnded() { }
    
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
     
    public void display(){        
        if (isEmpty()) {
            System.out.println("\nERROR: Empty Queue!");
            return;
        }//end if
                
        System.out.print("\n********** Display Queue **************\n");
        
        Node<E> current=front;
        do{
            System.out.println(current.data);
            current=current.next;
        }while(current!=front);
        
        System.out.println("***************************************\n"); 
    }//end of display
    
    public void enQueueRear(E value){  //like addLast in a CDLL
        @SuppressWarnings({ "unchecked", "rawtypes" })
		Node<E> newNode = new Node(value, null, null);
        
        if (isEmpty()){
            front = rear = newNode;
            newNode.next=front;
            newNode.prev=front;
        }
        else{
            newNode.prev=rear;
            rear.next=newNode;
            front.prev=newNode;
            newNode.next=front;
            rear = newNode;
        }//end if-else
        size++;
        System.out.println(value + " - Added to Queue (enQueueRear)");
    }//end of enQueueRear
    
    public Node<E> deQueueFront() {  //like removeFirst in a CDLL
        if (isEmpty()) {
            System.out.println("\nERROR: Queue Underflow!");
            return null;
        }//end if
        
        Node<E> temp=front;
        front = front.next;
        rear.next=front;
        front.prev=rear;
        size--;        
        if (size == 0) { rear =front = null; } 
        
        System.out.println(temp.data + "- Deleted from Queue (deQueueFront)");        
        return temp;
    }//end of deQueueFront
       
  //Lab 10 Tasks:
    public void enQueueFront(E value){  //like addFirst in a CDLL
        @SuppressWarnings({ "rawtypes", "unchecked" })
		Node<E> newNode = new Node(value, null, null);
        
        if (isEmpty()) {
            front = rear = newNode;
            newNode.next=front;
            newNode.prev=front;
        }
        else{
            newNode.next=front;
            newNode.prev=rear;            
            front.prev=newNode;
            rear.next=newNode;
            front = newNode;
        }//end if-else
        size++;
        
        System.out.println(value + " - Added to Queue (enQueueFront)");
    }//end of enQueueFront
    
    public Node<E> deQueueRear() {  //like removeLast in a CDLL
        if (isEmpty()) {
            System.out.println("\nERROR: Queue Underflow!");
            return null;
        }//end if
        
        Node<E> temp=rear;        
        rear = rear.prev;
        front.prev=rear;
        rear.next=front;
        size--;        
        if (size == 0) { rear =front = null; }  
        
        System.out.println(temp.data + "- Deleted from Queue (deQueueRear)");        
        return temp;
    }//end of deQueueRear

}//end of class