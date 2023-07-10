//{ Driver Code Starts
// Initial Template for Java

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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans[] = obj.nextGreaterElement(n, a);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int[] nextGreaterElement(int N, int arr[]) {
        // code here
        Stack<Integer> st=new Stack<>();
        int a[]=new int[N];
        
        for(int i=0;i<N;i++) a[i]=-1;
        
        for(int i =0;i<N*2;i++){
            int curr=arr[i%N];
            while(!st.empty()&&arr[st.peek()]<curr){
                a[st.peek()]=curr;
                st.pop();
            }if(i<N) st.push(i);
        }
        return a;
    }
}
