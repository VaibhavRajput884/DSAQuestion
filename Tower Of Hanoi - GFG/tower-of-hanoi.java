//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}






// } Driver Code Ends


// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi {

    public long toh(int n, int a, int c, int b) {
        long temp=0;
        // Your code here
        if(n==1){
            System.out.println("move disk 1 from rod "+a+" to rod "+c);
            return 1;
        }
        temp=temp + toh(n-1,a,b,c);
         System.out.println("move disk "+n+" from rod "+a+" to rod "+c);
         temp++;
        temp=temp + toh(n-1,b,c,a); 
        return temp;
        
    }
}