import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {  
        
        //Creating two Stacks
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
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
                //deleting first element of stack2 i.e. front of queue
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

