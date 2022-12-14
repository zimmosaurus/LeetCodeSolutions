package com.hazim.code.algorithm1;

public class LeetCode {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int t = 2;
        System.out.println(searchIndex(nums,t));
    }
    public static int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]<target){
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }
        return -1;
    }

    public static int firstBadVersion(int n){
        int start = 0;
        int end = n;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid))
                end = mid - 1;
            else
                start = mid+1;
            if(isBadVersion(mid) && !isBadVersion(mid-1))
                return mid;
        }
        return 1;
    }

    public static int searchIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left<= right){
            int idx = left + (right-left)/2;
            if(nums[idx] == target)
                return idx;
            if(nums[idx]<target)
                left = idx + 1;
            else
                right = idx - 1;
        }
        return left;
    }

    public static boolean isBadVersion(int n){
        int v = 5;
        return n == v;
    }
}
