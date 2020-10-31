package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Glowingbulbs {
    static long len;
    static ArrayList<Integer> nums;
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String g=br.readLine();
        int N = Integer.parseInt(g);
        while(N-->0)
        {
             String line= br.readLine();
             String ip=br.readLine();
             long k = Long.parseLong(ip);
              nums=new ArrayList();
             int i,j;
             for(i=0;i<40;i++)
             {
                 if(line.charAt(i)=='1')
                 {
                     nums.add(i+1);
                 }
             }
             len=nums.size();
             long t=bins(k);
             System.out.println(t);
        }
    }
    
    static long bins(long k)
    {
        long l=1; long h=(long)Math.pow(10,15); h*=37; long f=0;
        while(l<=h)
        {
            long mid=(l+h)/2;
            long check=call1( mid);
            if(check<k)
            {
                l=mid+1;
            }
            else {f=mid;h=mid-1;}
        }
        return f;
    }
    
    static long call1(long limit)
    {
        int y; long t=0; int n1=1;
        for(y=1;y<(int)Math.pow(2,len);y++)
        {
            int check1=y;
            long m1=1; int nof1=0,ind=0;
            while(check1!=0)
            {
                if((check1&1)>0)
                {
                    m1*=(long)nums.get(ind); nof1++;
                }
                
                ind++; check1=check1>>1;
            }
            if(nof1%2==0)
            {
                t-=limit/m1;
            }
            else
            t+=limit/m1;
        }
        return t;
    }
}
