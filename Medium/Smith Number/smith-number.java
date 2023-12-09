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
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static boolean isPrime(int a){
        if(a == 1) return false;
        if(a == 2 || a == 3) return true;
        for(int i=2; i<=Math.sqrt(a); i++){
            if(a%i == 0) return false;
        }
        return true;
    }
    public static int Sum(int n){
        int sum = 0;
        while(n > 0){
            sum += (n%10);
            n = n/10;
        }
        return sum;
        
    }
    public static int sumOfPrime(int n){
        int x = 1, sum = 0;
        while( n > 1){
            ++x;
            if(!isPrime(x)){
                continue;
            }
            while(n % x == 0){
                int a = Sum(x);
                sum += a; n = n/x;
            }
            
            
        }
        return sum;
    }
    
    static int smithNum(int n) {
        // code here
        int x= n, sum = 0;
        while(x > 0){
            sum += (x%10);
            x = x/10;
        }
        if(isPrime(n)) return 0;
        return (sum == sumOfPrime(n) ? 1 : 0);
        
    }
};