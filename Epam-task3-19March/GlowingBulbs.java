/**
 * Problem Description
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/glowing-bulbs/
 * @author anubhav
 */
import java.util.*;
public class GlowingBulbs
{   
    //Stores list of ON switches
    static List<Integer> switches = new ArrayList<>();
    
    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        
        //number of test cases
        int t = s.nextInt();
 
        long k, current, last, m = 0;
        int i,j;
        
        //final result i.e. kth glowing bulb
        long ans = 0;
 
        //iterating for all test cases
        while ( t>0 ) {
            t-=1;
            switches.clear();
            
            //storing switch status
            String switchString = s.next();
        
            k = s.nextLong();

            //iterating to check ON switches
            for(i =0 ; i< switchString.length(); i++){
                if(switchString.charAt( i ) == '1')
                    switches.add( i+1 );
            }
            
            //Initializing current and last bulb index
            current=1; last= 1000000000000000L;
 
            while ( current <= last ){
                m = (current+last) >> 1;
                int size = switches.size();   
                
                long res = 0;
                
                //iterating till 2^size
                for(i=1; i< (1 << size); i++ ){
                    long pr = 1;
                    int sign = -1 ;
                    
                    //iterating for all switches
                    for(j =0; j < size; j++ ){
                        
                        //Checking if odd
                        if( (i>>j) % 2== 1){
                            pr = pr * switches.get( j );
                            sign *= -1;
                        }
                    }
                    //updating result
                    res += (m/pr)*sign;
                }
                
                if(res < k){
                    //updating current index of bulb to check for next
                    current = m+1;
                }
                else{
                    //updating for kth bulb
                    ans = m;
                    //updating last bulb as per ON switches
                    last = m-1;
                }
            }
            System.out.println(ans);
        }
    }
}