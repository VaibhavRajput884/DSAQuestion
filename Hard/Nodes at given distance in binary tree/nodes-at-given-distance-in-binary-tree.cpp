//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// Tree Node
struct Node
{
    int data;
    Node* left;
    Node* right;
};

// Utility function to create a new Tree Node
Node* newNode(int val)
{
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;
    
    return temp;
}

// Function to Build Tree
Node* buildTree(string str)
{   
    // Corner Case
    if(str.length() == 0 || str[0] == 'N')
            return NULL;
    
    // Creating vector of strings from input 
    // string after spliting by space
    vector<string> ip;
    
    istringstream iss(str);
    for(string str; iss >> str; )
        ip.push_back(str);
        
    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));
        
    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);
        
    // Starting from the second element
    int i = 1;
    while(!queue.empty() && i < ip.size()) {
            
        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();
            
        // Get the current node's value from the string
        string currVal = ip[i];
            
        // If the left child is not null
        if(currVal != "N") {
                
            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->left);
        }
            
        // For the right child
        i++;
        if(i >= ip.size())
            break;
        currVal = ip[i];
            
        // If the right child is not null
        if(currVal != "N") {
                
            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }
    
    return root;
}


// } Driver Code Ends
/* A binary Tree node
struct Node
{
    int data;
    struct Node *left, *right;
};
*/

class Solution
{
private:

public:

unordered_map<Node*,Node*> parent;
    
    void parentNode(Node* curr,Node* par){
        if(curr==NULL){
            return;
        }
        parent[curr]=par;
        parentNode(curr->left,curr);
        parentNode(curr->right,curr);
    }
    
    Node* getTargetNode(Node*root,int target){
        if(root==NULL){
            return NULL;
        }
        if(root->data==target){
            return root;
        }
        Node* left_res = getTargetNode(root->left, target);
        Node* right_res = getTargetNode(root->right, target);
    
        if(left_res) return left_res;
        else return right_res;
    }



    vector <int> KDistanceNodes(Node* root, int target , int k)
    {
        // return the sorted vector of all nodes at k dist
        vector<int> ans;
        if(root==NULL){
            return ans;
        }
        parentNode(root,NULL);
        Node* targetNode = getTargetNode(root,target);
        
        queue<Node*> q;
        q.push(targetNode);
        unordered_set<Node*> visited;
        
        while(!q.empty() && k>0){
          k--;
          int size = q.size();
          for(int i=0;i<size;i++){
                Node* temp = q.front();
                q.pop();
                visited.insert(temp);
                
                if(!visited.count(temp->left) && temp->left){
                    q.push(temp->left);
                }
                if(!visited.count(temp->right) && temp->right){
                    q.push(temp->right);
                }
                if(!visited.count(parent[temp]) && parent[temp]){
                    q.push(parent[temp]);
                }
          }
        }
        
        while(!q.empty()){
            Node* curr = q.front();
            q.pop();
            ans.push_back(curr->data);
        }
        sort(ans.begin(),ans.end());
        return ans;
    } 
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    getchar();
    
    Solution x = Solution();
    
    while(t--)
    {
        string s;
        getline(cin,s);
        Node* head = buildTree(s);
        
        int target, k;
        cin>> target >> k;
        getchar();
        
        vector <int> res = x.KDistanceNodes(head, target, k);
        
        for( int i=0; i<res.size(); i++ )
            cout<< res[i] << " ";
        cout<<endl;
    }
    return 0;
}

// } Driver Code Ends