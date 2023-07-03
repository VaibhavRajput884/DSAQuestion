//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
   public int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        int i=0;
        int j=0;
        long currProd=1;
        int ans=0;
        while(i<n)
        {
            currProd=currProd*a[i];
            //j<n to avoid array out of index exception
            while(currProd>=k && j<n)
            {
                currProd=currProd/a[j];
                j++;
            }

// i<=j can lead to wrong answer Dry run for ([1 1 1] and k=1)
            if(i>=j)
            ans=ans+(i-j+1);
            
            i++;
        }
        return ans;
    }


}