import java.util.*;
class ListNode
    {
        int data;
        ListNode next;
        ListNode(int d)
        { 
               data = d; 
               next = null;
         }
    }
public class MiddleOfLinkedList
{
    ListNode head;  // head of list
  
    
     public void addToTheLast(ListNode ListNode) {
  if (head == null) {
   head = ListNode;
  } else {
   ListNode temp = head;
   while (temp.next != null)
    temp = temp.next;
   temp.next = ListNode;
  }
 }
	  
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			MiddleOfLinkedList llist = new MiddleOfLinkedList();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			ListNode head= new ListNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new ListNode(a));
			}
          
        GFG gfgobj = new GFG(); 
		//llist.head = new GFG().Middle(llist.head);
		System.out.println(gfgobj.getMiddle(llist.head));
        
		//llist.printList();
		
			t--;
		}
	}
}
class GFG
{
    // Function to find middle element a linked list
    int getMiddle(ListNode head){
        //initilizing current pointer to head
        ListNode currentPointer = head;
        
        //count variable counts the number of ListNodes in th list
        int count=0;
        
        // iterates for all the ListNodes
        while(currentPointer!=null){
            //increments 1 for every ListNode in the list
            count+=1;
            
            //updating current pointer
            currentPointer=currentPointer.next;
        }
        //getting middle ListNode position in the list
        count /= 2;
        
        //reinitializing current pointer to head
        currentPointer = head;
        
        //iterates unless middle element is not found i.e count=0
        while(count!=0){
            currentPointer = currentPointer.next;
            count-=1;
        }
        
        //returning middle element data
        return currentPointer.data;
   }
}