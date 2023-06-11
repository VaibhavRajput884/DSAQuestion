//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int A[], int N, int X)
    {   
        int minSum         = -1;
        int mindifference  = Integer.MAX_VALUE;
        Arrays.sort(A);
        for(int i=0;i<N;i++){
            int target = X-A[i];
            int lo      = i+1;
            int hi      = N-1;
            while(lo < hi){
                int tempSum = A[lo]+A[hi];
                int diff = Math.abs(A[i]+tempSum-X);
                if(diff < mindifference){
                    mindifference = diff;
                    minSum        = A[i]+tempSum;
                }
                if(tempSum > target){
                    hi--;
                }else if(tempSum < target){
                    lo++;
                }else{
                    return target+A[i];
                }
            }
        }
        return minSum;
    }
}