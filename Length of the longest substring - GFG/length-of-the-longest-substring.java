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
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        Set m=new HashSet<>();
        int max=0;
        int l=0;
        for(int i =0;i<S.length();i++){
            while(!m.add(S.charAt(i))){
                m.remove(S.charAt(l++));
            }
            
            max=Math.max(max,i-l+1);
            
        }return max;
    }
}