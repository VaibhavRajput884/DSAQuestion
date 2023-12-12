//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
static int maxGold(int n, int m, int M[][]){
        
        int maxAmount=Integer.MIN_VALUE;
        int[][] dp = new int[n][m];
        
        for(int col=m-1;col>=0;col--){
            for(int row=0;row<n;row++){
                dp[row][col]=M[row][col];
                if(col!=m-1){
                    int rightUp= (row-1 >= 0) ? dp[row-1][col+1] : 0;
                    int rightDown= (row+1<n) ? dp[row+1][col+1] : 0;
                    dp[row][col] += (Math.max(dp[row][col+1], Math.max(rightUp,rightDown)));
                }
                
                if(col==0){
                    maxAmount= Math.max(maxAmount, dp[row][col]);
                }
                
            }
        }
        return maxAmount;
        
    }
}