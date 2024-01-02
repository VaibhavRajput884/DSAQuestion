//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static class TrieNode {
		
		TrieNode[] children = new TrieNode[26];
		boolean terminal;
		
		TrieNode() {
			terminal = false;
			for (int i = 0; i < 26; i++) {
	            children[i] = null;
			}
		}
	};
    
    static TrieNode root;
	static String suggestion="";
	
	static void insert(String key) {
		TrieNode temp = root;
		int length = key.length();
		int index;
		
		for(int i = 0; i < length; i++) {
			index = key.charAt(i)-'a';
			if(temp.children[index] == null) {
				temp.children[index] = new TrieNode();
			}
			
			temp = temp.children[index];
		}
		temp.terminal = true;
	}
	
	static void displayContacts(String s, ArrayList<ArrayList<String>> list) {
		
		String prefix = "";
		TrieNode prev = root;
		for(int i = 0; i < s.length(); i++) {
			prefix += s.charAt(i);
			char lastChar = prefix.charAt(i);
			TrieNode curr = prev.children[lastChar-'a'];
			
			if(curr==null) {
				break;
			} 
			
			ArrayList<String> suggestions = new ArrayList<>();
            displayContactsUtil(curr, prefix, list, suggestions);
            list.add(new ArrayList(suggestions));
            prev = curr;
		}
	}
	
	static void displayContactsUtil(TrieNode curr, String prefix, ArrayList<ArrayList<String>> list, ArrayList<String> suggestions) {
	    if (curr.terminal) {
	        suggestions.add(prefix);
	    }
	    for (char i = 'a'; i <= 'z'; i++) {
	        TrieNode nextNode = curr.children[i - 'a'];
	        if (nextNode != null) {
	            displayContactsUtil(nextNode, prefix + i, list, suggestions);
	        }
	    }
	}
    
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s)
    {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        root = new TrieNode(); 
        for(String str : contact){
			insert(str);
        }
        displayContacts(s, list);
        int sizeOfList = list.size();
        while(sizeOfList != s.length()){
            list.add(new ArrayList<>(Collections.singletonList("0")));
            sizeOfList++;
        }
        
        return list;
    }
}