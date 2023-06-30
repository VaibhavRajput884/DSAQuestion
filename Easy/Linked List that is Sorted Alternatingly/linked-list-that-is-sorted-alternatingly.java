//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends


/*
Structure of node class is:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        
        // if(head==null && head.next==null){
        //     return head;
        // }
        
        // Node temp=null;
        // Node slow=head;
        // Node fast=head;
        // while(fast!=null && fast.next!=null){
        //     temp=slow;
        //     slow=slow.next;
        //     fast=fast.next.next;
            
        // }
        // temp.next=null;
        // Node l1=sort(head);
        // Node l2=sort(slow);
        
        // return mergeList(l1,l2);
        
        ArrayList<Integer> list =new ArrayList<>();
        Node temp=head;
        
        while(temp!=null){
            list.add(temp.data);
            temp=temp.next;
        }
        Collections.sort(list);
        Node dummy=new Node(0);
        temp=dummy;
        for(int e : list){
          Node  newNode=new Node(e);
          temp.next=newNode;
          temp=newNode;
        }
        return dummy.next;
   }


}