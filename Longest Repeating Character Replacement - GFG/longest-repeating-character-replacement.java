//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            s = s.toUpperCase();
            int ans = obj.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) { in = is; }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// class Solution {
//     public int characterReplacement(String s, int k) {
        
//         int length = s.length();
        
//         if (length == 0) {
//             return 0;
//         }
        
//         int[] charToCountMap = new int[26];
//         int i = 0;
//         int j = 0;
//         int maxCount = 0;
        
//         while (i < length) {
// 		    // Increase the count of the alphabet encountered at i
//             int count = ++charToCountMap[s.charAt(i)-'A'];
            
// 			// If the count of this alphabet is greater than the maxCount, then update
// 			// otherwise remove this alphabet
//             if (count > maxCount) {
//                 maxCount = count;
//             } else {
//                 k--;
//             }
            
// 			// shorten the window by increasing j
// 			// also reduce the count of alphabet at j
//             if (k < 0) {
//                 --charToCountMap[s.charAt(j)-'A'];
//                 k++;
//                 j++;
//             }
            
//             i++;
//         }
        
//         return i-j;
//     }
// }

class Solution {
    static int characterReplacement(String s, int k) {
        // code here
        int l=s.length();
        if(l==0){
            return 0;
        }
        int c[]=new int[26];
        int i=0;
        int j=0;
        int max=0;
        while(i<l){
            int count=++c[s.charAt(i)-'A'];
            
        
        if(count>max){
            max=count;
        }else{
            k--;
        }
        if(k<0){
            --c[s.charAt(j)-'A'];
            k++;
            j++;
        }
        i++;
    }
    return i-j;
        
    }
}
