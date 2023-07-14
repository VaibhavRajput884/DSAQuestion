//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int arr[], int n, int t){
        
        // code here
        int l=0;
        int r=0;
        int count=0;
        int sum=0;
        for(;r<n;r++){
            sum+=arr[r];
            while(l<r && sum>t){
                sum-=arr[l++];
                
            }
            if(sum==t) count++;
            for(int i=l;sum==t&&i<r&&arr[i]==0;i++)
                count++;
        }
        
        return count;
    }
}