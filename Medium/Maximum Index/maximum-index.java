//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
   static int maxIndexDiff(int A[], int N) { 
        
        // Your code here
      int left[]=new int[N];
      int right[]=new int[N];
       left[0]=A[0];
      right[N-1]=A[N-1];
      for(int i=1;i<N;i++){
          left[i]=Math.min(A[i],left[i-1]);
      }
      for(int j=N-2;j>=0;j--)
      {
          right[j]=Math.max(right[j+1],A[j]);
      }
      int i=0,j=0;
      int diff=0;
      while(i<N && j<N){
          if(left[i]<=right[j]){
          diff=Math.max(diff,j-i);
          j++;
          }
          else
          i++;
      }
      return diff;
}



}


