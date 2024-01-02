//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
static int maxProfit(int K, int N, int price[]) {
        
        int dp[][][] = new int[N+1][2][K + 1];
       
       for(int i = N-1 ; i >= 0 ; i--){
           for(int buy = 0 ; buy <= 1 ; buy ++){
               for(int k = K ; k >= 1 ; k--){
         
                 if(buy == 1){
                     dp[i][buy][k] = Math.max( -price[i] + dp[i+1][0][k] ,
                                        dp[i+1][1][k]);
                 }
                 else{
                      dp[i][buy][k] = Math.max( price[i] + dp[i+1][1][k-1] ,
                                        dp[i+1][0][k]);
                 }
                   
               }
           }
       }
       return dp[0][1][K];
    }
}