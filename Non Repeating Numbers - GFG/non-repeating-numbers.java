//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        
        for (int num : nums) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }
        
          int[] result = new int[2];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        
        // Swap the two numbers to get the correct order
        int temp = result[0];
        result[0] = result[1];
        result[1] = temp;
        
        return result;
    }
}