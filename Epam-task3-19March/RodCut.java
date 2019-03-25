/**
 * Problem Description
 * https://www.hackerearth.com/problem/algorithm/rod-cutting-problem-7/
 * @author anubhav
 *
 */
import java.util.Scanner;
class RodCut {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T,N,special_rods;
        //number of test cases
        T = sc.nextInt();
        
        //iterating for all test cases
        while(T>0){
            T-=1;
            
            //length of the rod
            N = sc.nextInt();
            //initially no. of special rods is 0
            special_rods = 0;
            
            //to know if second step is followed
            int step=0;
            // if length of rod is greater than 1
            if(N!=1){
                // iterates until size becomes 0
                while(N!=0){
                    // determines if step is followed
                    if((N&1)==0)
                        step = 2;
                    
                    N=N/2;
                    
                    //count rod as special if it's length is greater than 1
                    if(N!=1){
                        //updating no. of special rods
                        special_rods++;
                    }
                    // decrements special rod by one if it returns true
                    if(N==1 && step==2){
                        special_rods--;
                    }
                }
            }
            System.out.println(special_rods);
        }
    }
}