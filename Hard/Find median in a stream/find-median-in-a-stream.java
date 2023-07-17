//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    //Function to insert heap.
    static PriorityQueue<Integer> l=new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> h=new PriorityQueue<>();
    
    
    
    
    public static void insertHeap(int x)
    {
        // add your code here
        if(l.size()==h.size()){
            h.add(x);
            l.add(h.remove());
        }
        else{
            l.add(x);
            h.add(l.remove());
        }
        
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
       
       
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(l.size()==h.size()){
            return (l.peek() +h.peek())/2.0;
        }else return (double)l.peek();
    }
    
}