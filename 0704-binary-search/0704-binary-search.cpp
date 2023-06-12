class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low=0,mid=0;
        int h= nums.size()-1;
        while(low<=h){
             mid=(low+h)/2;
            if(nums[mid]>target){
                h=mid-1;
            }
            else if(nums[mid]==target){
                return mid;
            }
            else{
                low=mid+1;
            }
                
        }
        return -1;
        
    }
};