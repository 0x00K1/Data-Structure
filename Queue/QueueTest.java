public class QueueTest {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {

        System.out.println("Testing a Queue using Circular Array:");
        System.out.println("*************************************"); 
        
        QueueArray q1 = new QueueArray(5);
        q1.enQueue(10);
        q1.enQueue(20);
        q1.enQueue(30);
        q1.enQueue(40);
        q1.enQueue(50);
        q1.display();
        q1.deQueue();
        q1.deQueue();
        q1.deQueue();
        q1.display();
        q1.enQueue(60);
        q1.display();

        //-------------------------------------------------------------

        System.out.println("Testing a Queue using Linear Linked List:");
        System.out.println("*****************************************");
        
        @SuppressWarnings("rawtypes")
		QueueLinkedList q2 = new QueueLinkedList(); 
        q2.enQueue(10);
        q2.enQueue(20);
        q2.enQueue(30);
        q2.enQueue(40);        
        q2.display();        
        q2.deQueue();
        q2.deQueue();       
        System.out.println("Front Element: "+ q2.getFront());
        System.out.println("Rear Element: "+ q2.getRear());
        q2.enQueue(50);
        q2.display();
        
        //-------------------------------------------------------------
        
        System.out.println("Testing a Double Ended Queue using CDLL:");
        System.out.println("****************************************");
                
        @SuppressWarnings("rawtypes")
		QueueDoubleEnded q3=new QueueDoubleEnded();
        q3.enQueueFront(10);
        q3.enQueueFront(20);
        q3.enQueueFront(30);
        q3.enQueueFront(40);
        q3.enQueueRear(50);
        q3.enQueueRear(60);
        q3.deQueueFront();
        q3.deQueueRear();       
        System.out.println("Front Element: "+ q3.getFront());
        System.out.println("Rear Element: "+ q3.getRear());
        q3.display();
    }//end of main
}//end of class