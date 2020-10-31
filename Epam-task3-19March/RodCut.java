package algorithms;

import java.util.*;
public class Rodcut {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	int T=sc.nextInt();
	int ans=0;
	while(T-->0)
	{
	int n=sc.nextInt();
	int temp=3;
	while(temp<=n)
	{
	    ans++;
	temp=temp*2+1;    
	}
	 
		
	 
	System.out.println(ans);
 
    ans=0;
}
 
	}
 
}
