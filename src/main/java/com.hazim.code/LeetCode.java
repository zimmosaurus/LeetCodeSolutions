package com.hazim.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
//        System.out.println(searchInsert(nums,target));
//        System.out.println(reverseWords("Let's take LeetCode contest"));
//        int[] arr = {1,2,1,3,1,2,1};
//        System.out.println(nonDuplicate(arr));
        char[] c = {'h','e','l'};
        reverseChar(c);
//        System.out.println(c);
        String s = "dvdf";
        System.out.println(longestSubString(s));
    }
    public static boolean duplicate(int[] nums){
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    public static int longestSubString(String s ){
        if(s.length() == 0 )
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxValue = 0;
        for(int i = 0 , j = 0 ; i < s.length(); ++i){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j , map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxValue = Math.max(i-j+ 1, maxValue);
        }
        return maxValue;
    }

    public static int maxSubArray(int[] nums){
        if(nums.length == 0 )
            return 0;
        /*

        {5,4,-1,10,-4,2}
        int currMax = nums[0];
        int maxSoFar = nums[0];
        for(int i = 1 ; i < nums.length; ++i){
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        return maxSoFar;
         */

        int max_sum = nums[0];
        int[] newArr = new int[nums.length];
        newArr[0] = nums[0];
        for(int i = 1 ; i < nums.length ; ++i){
            int value = nums[i];
            int currMax = Math.max(value, value + newArr[i-1]);
            newArr[i] = currMax;
            max_sum = Math.max(currMax , max_sum);
        }
        return max_sum;
    }

    public static void reverseChar(char[] s){
        for(int i = 0 ; i < s.length/2 ; ++i){
            char t = s[i];
            System.out.println("t: " + t);
            s[i] = s[s.length-1-i];
            System.out.println("s[i]: " + s[i]);
            s[s.length-1-i] = t;
            System.out.println("s[s.length-1-i]: " + s[s.length-1-i]);
        }
    }

    /**
     * 1 , 3 ; target = 2
     * [0,2] mid = 1 ; num[1] = 3 ; right = mid - 1 = 0;
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public static int[] sortedSquaredArrays(int[] nums) {
        int[] newNums = new int[nums.length];
        int start = 0;
        int end = nums.length;
        int idx = end - 1;
        while (start <= end) {
            if (nums[start] * nums[start] > nums[end] * nums[end]) {
                newNums[idx--] = nums[start] * nums[start];
                ++start;
            } else {
                newNums[idx--] = nums[end] * nums[end];
                end--;
            }
        }
        return newNums;
    }

    public static void rotate(int[] nums, int moves) {
        // length 5 ; target 2 ; 3 4 0 1 2
        // target 6 ; 6 % 5 = 1; moves only 1 time; || target 2; 2 % 5 = 2;
        moves %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, moves - 1);
        reverse(nums, moves, nums.length - 1);


    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void moveZeros(int[] nums) {
        int zeroPtr = 0;
        int ptr;
        if (nums.length == 1)
            return;
        for (ptr = 1; ptr < nums.length; ++ptr) {
            if (nums[zeroPtr] == 0 && nums[ptr] != 0) {
                int temp = nums[ptr];
                nums[zeroPtr] = temp;
                nums[ptr] = 0;
                ++zeroPtr;
                ptr = zeroPtr + 1;
            }
        }
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.split(" ");
        for(String word: sArr){
            sb.append(reverseWord(word));

            sb.append(" ");
        }
//        return new String(sb).trim();
        return Arrays.stream(s.split("")).map( word -> word.length() < 4 ? word : new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
    }

    public static String reverseWord(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = s.toCharArray();
        for (int i = charArr.length - 1; i > -1; --i) {
            sb.append(charArr[i]);
        }
        return new String(sb);
    }

    public static int nonDuplicate (int[] arr){
        int result = arr[0];
        for(int i = 1 ; i < arr.length; ++i)
            result^=arr[i];
        return result;
    }

    public static int[][] filledFlood(int[][] image, int startRow, int startCol , int color){
        int startColor = image[startRow][startCol]; //color of starting cord
        if(startColor != color)
            dfs(image,startRow,startCol,startColor,color);

        return image;
    }

    public static void dfs(int[][] image, int startRow, int startCol, int startColor, int color) {
        if (image[startRow][startCol] == startColor){
            image[startRow][startCol] = color;
            if (startRow >= 1)
                dfs(image, startRow - 1, startCol, startColor, color); // go left in Row
            if (startCol >= 1)
                dfs(image, startRow, startCol - 1, startColor, color); // go left in Col
            if (startRow + 1 < image.length)
                dfs(image, startRow + 1, startCol, startColor, color); // go right in row
            if (startCol + 1 < image[0].length)
                dfs(image, startRow, startCol + 1, startColor, color); // go right in Col
    }
    }

}