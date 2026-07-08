class Solution {
      public static int firstOccurences(int nums[],int target){
        int left=0;
        int right=nums.length-1;
        int index  =-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target) index = mid;
            if(target <= nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return index;
      }
      public static int LastOccurencces(int nums[],int target){
        int left=0;
        int right  =nums.length-1;
        int index = -1;
       while(left<=right){
                 int mid = left+(right-left)/2;
                 if(nums[mid]==target) index=mid;
                 if(target>=nums[mid]) left=mid+1;
                 else right=mid-1;
       }
       return index;
      }
    public int[] searchRange(int[] nums, int target) {
       int res[]=new int[2];
       res[0]=firstOccurences(nums,target);
       res[1]=LastOccurencces(nums,target);
       return res; 
    }
}
