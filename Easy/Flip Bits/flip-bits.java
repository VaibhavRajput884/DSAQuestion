//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
  int zero_count=0;
        int one_count=0;
        int max=Integer.MIN_VALUE;
        
        for(int val:a){
            if(zero_count<0) zero_count=0;
            if(val==1){
                one_count+=1;
                zero_count-=1;
            }
            if(val==0)zero_count+=1;
            
            max=Math.max(zero_count,max);
        }
        if(max<0) return one_count;
        return max+one_count;
    }
}
