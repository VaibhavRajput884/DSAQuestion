//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    int getMinDiff(int arr[], int n, int k) {
    // Sort the array in ascending order
    sort(arr, arr + n);
 
    // Initialize the minimum difference
    int minDiff = arr[n - 1] - arr[0];
 
    // Iterate through the array to find the minimum difference
    for (int j = 1; j < n; j++) {
        // Check if the difference is less than zero and continue if true
        if (arr[j] - k < 0) continue;
 
        // Update the minimum difference based on the current elements
        minDiff = min(minDiff, max(arr[n - 1] - k, arr[j - 1] + k) - min(arr[0] + k, arr[j] - k));
    }
 
    // Return the minimum difference
    return minDiff;
}
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> k;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.getMinDiff(arr, n, k);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends