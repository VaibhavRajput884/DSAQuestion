//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	int cur=0;
        
        for(int i=1;i<n;i++)
        {
            //check if cur is a celebrity chance bhi h to i usko janega hi na
            if(M[i][cur]==1)
            {
            
                continue;
            }
            else
            {
            
                cur=i;
            }
        }
        int cnt1=0;
       int cnt=0;
       for(int i=0;i<n;i++)
       {
         
               cnt+=M[i][cur];
           
       }
       for(int i=0;i<n;i++)
       {
           cnt1+=M[cur][i];
       }
       
       if(cnt!=n-1||cnt1>0)
       return -1;
       
       return cur;
    }
}