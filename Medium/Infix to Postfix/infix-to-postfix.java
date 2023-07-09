//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to convert an infix expression to a postfix expression.
    
    static int precedence(char ch)
    {
        if(ch=='^') return 3;
        else if(ch=='/' || ch=='*')return 2;
        else if(ch=='+' || ch=='-')return 1;
        else return -1;
    }
    static boolean isChar(char c)
    {
        if(c=='/' || c=='*' || c=='+' || c=='-' || c=='^' ||c=='(' ||c==')')
        return false;
        return true;
    }
    public static String infixToPostfix(String s) {
        // Your code here
        Stack<Character> sigma=new Stack<>();
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(isChar(ch))
            ans+=ch;
            else if(ch=='(')
            sigma.push(ch);
            else if(ch==')')
            {
                while(sigma.peek()!='(')
                {
                    ans+=sigma.pop();
                }
                sigma.pop();
            }
            else{
                while(sigma.isEmpty()==false && precedence(ch)<=precedence(sigma.peek()))
                {
                    ans+=sigma.pop();
                }
                sigma.push(ch);
            }
        }
        while(!sigma.isEmpty())
        ans+=sigma.pop();
        return ans;
    }
}