//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

  int maxIndexDiff(int arr[], int n) {
        // code here
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        //loop for storing index in stack whose value appears in decreasing order
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty() || arr[stack.peek()] > arr[i]) {
                stack.push(i);
            }
        }
        //Now we traverse from right to left
        int i = n-1;
        while(i>=0) {
            if(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                ans = Math.max(ans, i-stack.pop());
                continue;
            }
            i--;
        }
        return ans;
    }
}