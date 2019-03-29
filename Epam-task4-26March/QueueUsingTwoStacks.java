import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {  
        
        //Creating two Stacks
        arrayStack s1 = new arrayStack();
        arrayStack s2 = new arrayStack();
        
        //Creating object of Scanner Class
        Scanner sc = new Scanner(System.in);
        
        int q,type,x;
        
        //number of queries
        q = sc.nextInt();
        
        //iterating for each queries
        for(int k=0;k<q;k++){
            type = sc.nextInt();

            //Enqueue
            if(type==1){
                x = sc.nextInt();
                //Push to stack 1
                s1.push(x);
            }
            //Dequeue
            if(type==2){
                //moving all elements from stack1 to stack2
                if(s2.empty()){
                    while(!s1.empty()){
                        s2.push(s1.peek());
                        s1.pop();
                    }
                }
                //poping first element of stack2 i.e. front of queue
                s2.pop();
            }
            //Printing Last element
            if(type==3){
                //moving all elements from stack1 to stack2
                if(s2.empty()){
                    while(!s1.empty()){
                        s2.push(s1.peek());
                        s1.pop();
                    }
                }
                //Printing First element of stack2 is that front of queue
                System.out.println(s2.peek());
            }
        }
    }
    
}

class arrayStack{

    int arr[];
    int top, size, len;

    /*  Constructor for arrayStack */

    public arrayStack(){
        size = 100000; // array max size
        len = 0;
        arr = new int[size];
        top = -1;
    }

    /*  Function to check if stack is empty */
    public boolean empty(){

        return top == -1;

    }

    /*  Function to check the top element of the stack */
    public int peek(){

        return arr[top];

    }

    /*  Function to add an element to the stack */
    public void push(int i)

    {

        if(top + 1 < size )

            arr[++top] = i;

        len++ ;

    }

    /*  Function to delete an element from the stack */
    public int pop(){

        len-- ;

        return arr[top--]; 

    }    

}