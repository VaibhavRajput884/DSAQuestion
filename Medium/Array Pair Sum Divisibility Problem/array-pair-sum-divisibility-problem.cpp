//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
  public:
    bool canPair(vector<int> nums, int k) {
        // Code here.
        int n = nums.size() ;
        if(n&1)
        return false; 
        for(int i =0 ; i<n ;i++ )
        {
            nums[i]%=k ;
        }
        sort(begin(nums), end(nums)) ;
        
        int l =0 , r = n-1; 
        while(nums[l]==0 && l<n )
        {
            l++ ;
        }
        if(l&1)
        return false; 
        
        while(l<=r)
        {
            if(nums[l]+nums[r]!=k)
            return false; 
            else if(nums[l]+nums[r]==k)
            {
                l++ ,r-- ;
            }
        }
        return true ;
    }
};
 

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, k;
        cin >> n >> k;
        vector<int> nums(n);
        for (int i = 0; i < nums.size(); i++) cin >> nums[i];
        Solution ob;
        bool ans = ob.canPair(nums, k);
        if (ans)
            cout << "True\n";
        else
            cout << "False\n";
    }
    return 0;
}
// } Driver Code Ends