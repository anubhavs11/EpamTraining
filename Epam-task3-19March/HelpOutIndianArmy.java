
/**
 * Problem Description
 * https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/help-out-the-indian-army/description/
 * @author anubhav
 *
 */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {

    // list for left and right safe distance for every checkpoint
    List<Long> list1=new ArrayList<Long>();
    List<Long> list2=new ArrayList<Long>();
    
    int N;
	
	long S, E, x, d;
	long left, right, ans;
	
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	S = sc.nextLong();
	E = sc.nextLong();
	
	// iterating Every checkpoint
	for(int i=0; i<N;i++)
	{
		x = sc.nextLong();
	    d = sc.nextLong();
		
		// as this is the range the army is protected 
		left = x-d;  
		
		// so we calculate the range by calculating left value and right 
		right = x+d;  
		
		if ((right<=S) || (left>=E))      
			continue;
		// as we comparing the values for because if the value of left is less than 
		left = Math.max(left, S);        
		 
	    // the S value then we will include the value of S
		right = Math.min(right, E);    
		
		// make pair of elements 
		list1.add(left);
		list2.add(right);
	}
	
	
	if(list1.size()==0)
	{
		System.out.println(E-S);
	}
	
	/**
	 * Sorting list1 and updating corresponding values in list2 
	 * So as to start from ordered range
	 */
	//creating HashMap for list1 and list2
    HashMap<Long,Long> pair = new HashMap<Long,Long>(); 
    for(int i=0;i<list1.size();i++){
        pair.put(list1.get(i),list2.get(i));    
    }
    //Sorting the HashMap keys i.e. list1
	Collections.sort(list1);
	// updating corresponding values of list2
	for(int i=0;i<list1.size();i++){
        list2.set(i,pair.get(list1.get(i)));
    }
	
	// exits the system if no elements found in the lists
	if(list1.size()==0){
	    System.exit(0);
	}
	// we taken the first value
	left = list1.get(0); 
	
	 // we take the second value
	right = list2.get(0);
	
	// calculated the difference from smallest range, so the difference
	// will be added in answer
	ans = Math.max(0L, left-S);  
    
    //iterating all the list elements
	for(int i=1;i<list1.size();i++)
	{
	    // checks if left safest place is greater than right safest place of previous checkpost
		if(list2.get(i)>right)
		{
		    //updating total unsafe distance
			ans = ans + Math.max(0L, list1.get(i) - right);
			
			/** updating previous checkpoint right safest place as
			*   current checkpoint right safest place
			*/
			right = list2.get(i);
		}
	}
	// adding unsafe distance between last checkpost's rightmost safest place
	// to the last destination i.e. E
	ans = ans + Math.max(0L, E - right); 
	
	//printing total unsafe distance b/w E and S
	System.out.println(ans); 
	}
}
