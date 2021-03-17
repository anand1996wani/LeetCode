/*

Search in Rotated Sorted Array

https://leetcode.com/problems/search-in-rotated-sorted-array/

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.


*/

class Solution {
    
    public int BinarySearch(int[] nums, int start, int end, int target){
        int mid = -1;
        while(start <= end){
            mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
    
    public int findRotationPivot(int[] nums, int start, int end){
        int mid = -1;
        while(start < end){
            mid = ((start + end)/2);
            if(nums[mid] > nums[mid + 1]){
                return mid + 1;
            }else if(nums[start] < nums[mid]){
                start = mid;
            }else{
                end = mid;
            }
        }
        return 0;
    }
    
    public int search(int[] nums, int target) {
        int index = findRotationPivot(nums, 0, nums.length - 1);
        System.out.println(index);
        
        int c = -1, c1 = -1, c2 = -1;
        
        if(index == 0){
            c = BinarySearch(nums, 0, nums.length - 1, target);
            return c;
        }else{
            c1 = BinarySearch(nums, 0, index - 1, target);
            c2 = BinarySearch(nums, index, nums.length - 1, target);
            if(c1 != -1){
                return c1;
            }else if(c2 != -1){
                return c2;
            }else{
                return -1;
            }
        }
    }
}
