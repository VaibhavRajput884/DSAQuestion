//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
        // code here
        Set m = new HashSet<>();
        int max=0;
        int left=0;
        int i;
        for(i=0;i<s.length();i++){
            while(!m.add(s.charAt(i))){
                m.remove(s.charAt(left++));
            }
            max=Math.max(max,i-left+1);
        }
        return max;
        
    }
}