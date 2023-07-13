//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends


class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int ans[]=new int[n];
        int count=1;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<price.length;i++)
        {
               if(st.isEmpty()){
                   st.push(i);
                   ans[i]=1;
               }
               else{
                     while(!st.isEmpty() && price[st.peek()]<=price[i])
                     {
                         st.pop();
                     }
              
                  if(st.isEmpty())
                  {
                        ans[i]=i+1;
                  }
                  else{
                        count=i-st.peek();
                        ans[i]=count;
            
                  }
                  st.push(i);
               }
               
        }
        return ans;
    }
    
} 