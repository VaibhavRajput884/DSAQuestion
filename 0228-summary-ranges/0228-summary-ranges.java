class Solution {
public List summaryRanges(int[] nums) {
List list= new ArrayList<>();
for(int i=0; i<nums.length ; i++){
int start=nums[i];
while( i+1<nums.length && nums[i+1]==nums[i]+1){
i++;
}
if(start!=nums[i]){
String res=start+"->"+nums[i];
list.add(res);
}else{
list.add(start+"");
}
}
return list;

}
}