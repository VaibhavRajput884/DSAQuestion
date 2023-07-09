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
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution
{
    static boolean isOperator(char ch)
    {
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
        {
             return true;
        }
         return false;
    }
    
    static String convert(String exp)
    {
        Stack<String> st=new Stack<>();
        int n=exp.length();
        
        for(int i=n-1; i>=0; i--)
        {
            char c=exp.charAt(i);
            if(isOperator(c))
            {
                String op1=st.pop();
                String op2=st.pop();
                
                String temp="("+op1+c+op2+")";
                st.push(temp);
            }
            else
            {
                st.push(c+"");
            }
        }
        return st.pop();
    }
    static String preToInfix(String pre_exp) {
        // code here
        return convert(pre_exp);
    }
}