/**
 * Problem Description
 * https://www.hackerearth.com/practice/algorithms/sorting/bucket-sort/practice-problems/algorithm/sort-the-array-5/
 * @author anubhav
 */
import java.util.*;
class Bucket{
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        
        //Creating 2D empty bucket
        List<List<Integer> > bucket=new ArrayList<>();
        for(int i=0;i<k;i++){
            bucket.add(new ArrayList<>());
        }
        // Input of array elements in ArrayList
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        
        for(int i=0;i<n;i++){
            //adding elements to the 'item % k'th ArrayList as index
            List<Integer> bucket_list=bucket.get(list.get(i)%k);
            
            //adding element its corresponding ArrayList
            bucket_list.add(list.get(i));
            
            //updating bucket
            bucket.set(list.get(i)%k,bucket_list);
        }
        
        for(int i=0;i<k;i++){
            //Sorting each ArrayList
            Collections.sort(bucket.get(i)); 
        }
       
        for(int i=0;i<k;i++){
            //if ArrayList is not empty
            if(bucket.get(i).size()>0){
                 //iterating ArrayList from last indexed to first
                for(int j:bucket.get(k-1-i)){
                    //printing elements of the ArrayList
                    System.out.print(j+" ");
                }
            }
        }
    }
}