//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   ArrayList<Long> nthRowOfPascalTriangle(int n) {
         ArrayList<Long>  a = new ArrayList<>();
         long ans=1,mod=(long)1e9+7;
        for(int j=0;j<n;j++){
             a.add(ans);
             for(int i=j-1;i>=1;i--)
                 a.set(i,(a.get(i)+a.get(i-1))%mod);
         }return a;
}
}