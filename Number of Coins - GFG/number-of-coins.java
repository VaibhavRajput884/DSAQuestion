//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    int[][] dp = new int[M][V+1];
	    for(int[] arr : dp)
	    Arrays.fill(arr,-1);
	   if(helper(coins,0,V,dp)>=Integer.MAX_VALUE)
	    return -1;
	    return helper(coins,0,V,dp);
	} 
	int helper(int[] coins, int ind, int sum, int[][] dp){
	    if(sum<0 || ind==coins.length)
	    return Integer.MAX_VALUE;
	    if(sum==0)
	    return 0;
	    if(dp[ind][sum]!=-1)
	    return dp[ind][sum];
        int pick = helper(coins,ind,sum-coins[ind],dp);
        if(pick!=Integer.MAX_VALUE)
        pick+=1;
        int notPick = helper(coins,ind+1,sum,dp);
        return dp[ind][sum]=Math.min(pick,notPick);
	}
}