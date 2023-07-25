//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public Node fun(int[] inorder,int[] preorder,int n,int j,int k)
    {
        if(j>k)
        return null;
        Node root=new Node(preorder[ind]);
        ind++;
        int g=-1,s=0;
        for(g=j;g<=k;g++)
        {
            if(inorder[g]==root.data)
            {
                s=1;
                break;
            }
        }
        if(s==0)g=-1;
        root.left=fun(inorder,preorder,n,j,g-1);
        root.right=fun(inorder,preorder,n,g+1,k);
        return root;
    }
    public int ind=0;
    public Node buildTree(int inorder[], int preorder[], int n)
    {
        Node head=fun(inorder,preorder,n,0,n-1);
        return head;
    }
}
