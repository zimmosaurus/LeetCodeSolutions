package com.hazim.code.algorithm1;

public class LeetCode {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeros(arr);
        for(int i : arr)
            System.out.println(i);
    }

    public static int[] twoSum(int[] nums,int target){
        if(nums.length<2){
            return nums;
        }
        int start = 0;
        int end = nums.length-1;
        int[] ans = new int[2];
        while(start<end){
            int sum = nums[start] + nums[end];
            if(sum == target){
                ans[0] = start+1;
                ans[1] = end+1;
                break;
            }
            if(sum < target){
                ++start;
            }else{
                --end;
            }
        }
        return ans;
    }
    public static void moveZeros(int[] nums){
        int idx = 0;
        for(int i : nums){
            if(i!=0){
                nums[idx++] = i;
            }
        }
        for(int i = idx ; i < nums.length; ++i){
            nums[i] = 0;
        }
    }
    public static int[] rotateArrays(int[] nums, int k){
        //dont have to do exactly k-steps, just the remainder is sufficient
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

        return nums;
    }
    public static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = end;
            nums[end] = temp;
            ++start;
            --end;
        }
    }

    public static int[] sortedSquares(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int idx = end;
        int[] ans = new int[nums.length];
        while(start<=end){
            int startSq = nums[start]*nums[start];
            int endSq = nums[end]*nums[end];
            if(startSq>endSq){
                ans[idx--] = startSq;
                ++start;
            }
            else{
                ans[idx--] = endSq;
                --end;
            }
        }
        return ans;
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
