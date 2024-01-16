//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberSequence(int m, int n)
    {
       int dp[][] = new int[m+1][n+1];
       for(int i = 0;  i<=m;i++)
       {
           for(int j = 0; j<=n;j++)
           {
               if(i == 0 || j ==0 || i <j)
               {
                   dp[i][j] = 0;
               }
           else if(j ==1)
               {
                   dp[i][j] = i;
               }
               else
               {
                   dp[i][j] = dp[i/2][j-1] + dp[i-1][j];
               }
           }
           
       }
return dp[m][n];
}
}