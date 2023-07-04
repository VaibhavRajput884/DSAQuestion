//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> list=new ArrayList<>();
        helper(list,n,"(",1,0);
        return list;
    }
    public void helper(List<String> list , int n , String curr,int opn , int close){
        if(curr.length()==2*n ){
            list.add(curr);
            return ;
            
        }
        if(opn<n){
            helper(list,n,curr+"(",opn+1,close);
        }
        if(close<opn){
            helper(list,n,curr+")",opn,close+1);
        }
    }
}