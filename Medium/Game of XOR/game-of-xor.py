#User function Template for python3

class Solution:
    def gameOfXor(self, N , A):
        xor = 0
        for i in range(N):
            freq = (i + 1) * (N - i)
            if freq % 2 == 1:
                xor ^= A[i]
        return xor 

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N=int(input())
        A=list(map(int,input().split()))
        
        ob = Solution()
        print(ob.gameOfXor(N,A))
# } Driver Code Ends