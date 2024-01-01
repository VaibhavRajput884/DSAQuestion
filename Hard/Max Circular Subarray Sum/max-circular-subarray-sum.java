//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends

class Solution{

  
    static int circularSubarraySum(int a[], int n) {

       int maxSum = kadane(a, n);

        int totalSum = 0;
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += a[i];

            
            currentSum = Math.min(a[i], a[i] + currentSum);
            minSum = Math.min(minSum, currentSum);
        }

        // Calculate the circular subarray sum
        int circularSum = totalSum - minSum;

        // Choose the maximum of the two cases
        return Math.max(maxSum, (circularSum == 0) ? maxSum : circularSum);
    }

   
    static int kadane(int a[], int n) {
        int max = Integer.MIN_VALUE;
        int currentMax = 0;

        for (int i = 0; i < n; i++) {
            currentMax = Math.max(a[i], a[i] + currentMax);
            max = Math.max(max, currentMax);
        }

        return max;
    }
    
}

