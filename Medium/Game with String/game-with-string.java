//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        int[] frequency = new int[26];
        
        // Count the frequency of each character in the string
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        // Use a priority queue to store frequencies in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        // Add frequencies to the priority queue
        for (int freq : frequency) {
            if (freq > 0) {
                pq.add(freq);
            }
        }
        
        // Remove k characters or reduce the frequency of characters
        while (k-- > 0 && !pq.isEmpty()) {
            int top = pq.poll(); // Get the character with the highest frequency
            top--; // Reduce its frequency by 1
            if (top > 0) {
                pq.add(top); // Re-add it to the priority queue if its frequency is still positive
            }
        }
        
        // Calculate the minimum value of the string
        int minValue = 0;
        while (!pq.isEmpty()) {
            int freq = pq.poll();
            minValue += freq * freq; // Sum of squares of the count of each distinct character
        }
        
        return minValue;
    }
}