public class QueueArray 
{
    private int front = 0, rear = 0;
    private int size = 0;
    private int[] queue;

    QueueArray(int capacity) { queue = new int[capacity];}
    
    public boolean isEmpty() {return size==0; } 
    public boolean isFull() {return size==queue.length; }
    
    public int size() { return size; }

    public int getFront(){
        if (isEmpty()) {
            System.out.println("\nERROR: Empty Queue!");
            return -1;
        }//end if

        return queue[front];
    }//end of getFront

    public int getRear(){
        if (isEmpty()) {
            System.out.println("\nERROR: Empty Queue!");
            return -1;
        }//end if
        
        return queue[rear-1];
    }//end of getRear    
    
    public void display(){ 
        if (isEmpty()) {
            System.out.println("\nERROR: Empty Queue!");
            return;
        }//end if
                
        System.out.print("\n********** Display Queue **************\n");
        
        if (rear > front) //normal linear array
            for (int i = front; i < rear; i++) 
                 System.out.println(queue[i]);
        else{ //for circular array
            for (int i = front; i < queue.length; i++) 
                System.out.println(queue[i]);
            
            for (int i = 0; i < rear; i++) 
                System.out.println(queue[i]);
            
        }//end if-else        
        System.out.println("***************************************\n"); 
    }//end of display
  
    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("\nERROR: Queue Overflow!");
            return;
        }//end if 

        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
        System.out.println(value + " - Added to Queue");
    }//end of enQueue
      
    public int deQueue(){
        if (isEmpty()) {
            System.out.println("\nERROR: Queue Underflow!");
            return -1;
        }//end if

        int temp=queue[front];
        front = (front + 1) % queue.length;
        size--;
        System.out.println(temp + "- Deleted from Queue");
        return temp;
    }//end of deQueue    
}//end of class
