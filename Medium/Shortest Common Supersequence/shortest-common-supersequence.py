#User function Template for python3

class Solution:
    
    #Function to find length of shortest common supersequence of two strings.
    def shortestCommonSupersequence(self, X, Y, m, n):
            l=[[0 for i in range(n+1)] for j in range(m+1)]
            for i in range(1,m+1):
                for j in range(1,n+1):
                    if X[i-1]==Y[j-1]:
                        l[i][j]=1+l[i-1][j-1]
                    else:
                        l[i][j]=max(l[i-1][j],l[i][j-1])
            return m+n-l[-1][-1]


#{ 
 # Driver Code Starts
#Initial Template for Python 3

#contributed by RavinderSinghPB
if __name__ == '__main__': 
    t=int(input())
    for tcs in range(t):
        X,Y=input().split()
        
        print(Solution().shortestCommonSupersequence(X,Y,len(X),len(Y)))
        
# } Driver Code Ends