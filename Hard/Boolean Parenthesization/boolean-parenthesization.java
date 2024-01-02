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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     static final int mod = 1003;
    
    static int countWays(int N, String S){
        
        long dp[][][] = new long[N][N][2];
        for(long[][] row1 : dp){
            for(long[] row : row1){
            Arrays.fill(row , -1);
            }
        }
        return  (int) count(0 , N-1 , 1 , S , dp) % mod;
    }
    static long count(int i, int j , int isTrue , String S , long dp[][][]){
        
        if(i > j) return 0;
        
        if(i == j){
            if(isTrue == 1) {
                return S.charAt(i) == 'T' ? 1 : 0; 
            }
            else{
                return S.charAt(i) == 'F' ? 1 : 0; 
            }
        }
        
        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        
        long ways = 0;
        
        for(int k = i+1 ; k <= j - 1 ; k += 2){
            
            long lT = count(i , k - 1 , 1 , S , dp);
            long lF = count(i , k - 1 , 0 , S , dp);
            long rT = count(k + 1 , j , 1 , S , dp);
            long rF = count(k + 1 , j , 0 , S , dp);
            
            if(S.charAt(k) == '&'){
                if(isTrue == 1){
                    ways = (ways + (lT * rT) % mod ) % mod;
                }
                else{
                    ways = (ways + (lF * rT) % mod  + (lT * rF) % mod + (lF * rF) % mod ) % mod;
                }
            }    
            else if(S.charAt(k) == '|'){
                if(isTrue == 1){
                ways = (ways + (lT * rT) % mod + (lF * rT) % mod  + (lT * rF) % mod ) % mod;
                }
                else{
                    ways = (ways + (lF * rF) % mod ) % mod;
                }
            }
            else{
                if(isTrue == 1){
                ways = (ways + (lT * rF) % mod + (lF * rT) % mod ) % mod;
                }
                else{
                    ways = (ways + (lF * rF) % mod  + (lT * rT) % mod ) % mod;
                }
            }
        }
        return dp[i][j][isTrue] = ways;
    }
}