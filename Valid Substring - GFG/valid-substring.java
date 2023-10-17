//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String s) {
        // code here
        
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            if(st.isEmpty() || s.charAt(i)=='('){
                st.push(i);
            }
            else{
                if(s.charAt(st.peek())=='('){
                    st.pop();
                }
                else{
                    st.push(i);
                }
            }
        }
        if(st.isEmpty()){
            return s.length();
        }
        int max = 0;
        if(st.get(0)!=0){
            max = st.get(0);
        }
        if(s.length()!=st.peek()+1){
            max = Math.max(max,s.length()-st.peek()-1);
        }
        while(st.size()>1){
            max = Math.max(max,st.pop()-st.peek()-1);
        }
        return max;
        
    }

};