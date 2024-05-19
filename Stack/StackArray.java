public class StackArray {
    
    int top;            //top element of the stack
    int[] stack;        //stack array

    public StackArray(int capacity) {
        stack = new int[capacity];
        top = -1;
    }//end of constructor

    public boolean isEmpty() { return (top == -1);  }
    public boolean isFull() { return top == (stack.length - 1);  }
    public int size() { return top + 1; }

    public int top() {
        if (isEmpty()) {
            System.out.println("\nERROR: Empty Stack!");
            return -1;
        }//end if

        return stack[top];
    }//end of top

    public void display() {
        if (isEmpty()) {
            System.out.println("\nERROR: Empty Stack!");
            return;
        }//end if
                
        System.out.print("\n********** Display Stack **************\n");
        
        for (int i = top; i >= 0; i--) 
            System.out.println(stack[i]);
        
        System.out.println("***************************************\n"); 
    }//end of display

    public void push(int value) {
        if (isFull()) {
            System.out.println("\nERROR: Stack Overflow!");
            return;
        }//end if 

        stack[++top] = value;
        System.out.println(value + " has been PUSHED successfully!");
    }//end of push

    public String pop() {
        if (isEmpty()) {
            return "\nERROR: Stack Underflow!";
        }//end if
        
        try {
        	return stack[top] + " has been POPPED successfully!\n";
        } finally {
        	top--;
        }
    }//end of pop
    
    public void makeEmpty(){
        if (isEmpty()) {
            System.out.println("\nStack is already empty!");
            return;
        }//end if

        for (int i = top; i >= 0; i--) 
            stack[i]=0;
            
        top=-1; //this line is enough, no need for the loop actually    
    }//end of makeEmpty

    

public static void main(String[] args) {
       
       System.out.println( "Testing a Stack using Array: ");
       System.out.println("****************************");
        
       //1. start pushing elements 
       StackArray stack1=new StackArray(5);
       stack1.push(10);
       stack1.push(30);
       stack1.push(50);
       stack1.push(60); 
       stack1.push(80);
       stack1.push(100); //stack overflow
       stack1.display();

       System.out.println("Top of stack: "+ stack1.top());
       System.out.println("Size of stack: "+ stack1.size()+"\n");    
       
       //2. start poping:
       stack1.pop();
       stack1.pop();
       stack1.pop();
       stack1.pop();
       stack1.pop();
       stack1.pop();  //stack underflow
       stack1.display();  //empty stack
       
       System.out.println("Top of stack: "+ stack1.top());
       System.out.println("Size of stack: "+ stack1.size());
        
    }//end of main    
}//end of class