class Solution {
    public int[] searchRange(int[] nums, int target) {

        
        // for brute force use flag
        // Below is using binary search
        
        int low =0;
        int n = nums.length;
        int high = n-1;
        int start = -1;
        
        while(low <= high){
            int mid = (low + high) / 2 ;
            
            
            if(nums[mid] ==target){
                start = mid;
                high = mid -1;
                
            }
            else if(nums[mid]>target){
                high = mid -1;
                
            }else{
                low = mid +1;
                
            }
            
            
        }
        
        
        low =0;
        high = n-1;
        int end = -1;
        
        while(low <= high){
            int mid = (low + high) / 2 ;
            
            
            if(nums[mid] == target){
                end = mid;
                low = mid + 1;
                
            }
            else if(nums[mid]>target){
                high = mid -1;
                
            }else{
                low = mid +1;
                
            }
            
            
        }

        int[] arr = new int [2];
        arr[0]= start;
        arr[1] = end;

        return arr;
    }
}