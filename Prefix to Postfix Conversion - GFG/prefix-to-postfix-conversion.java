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
            String ans = obj.preToPost(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        Stack<String> st = new Stack<>();
        for(int i=pre_exp.length()-1; i>=0; i--){
            char ch = pre_exp.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                st.push(String.valueOf(ch));
            }else{
                String a = st.pop();
                String b = st.pop();
                st.push(a+b+ch);
            }
        }
        return st.pop();
    }
}