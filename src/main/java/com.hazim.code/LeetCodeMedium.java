package com.hazim.code;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeMedium {
    public static int count = 0;
    public static void main(String[] args) {
        String word = "asb";
        char[] w = word.toCharArray();
        Arrays.sort(w);
        System.out.println(new String(w));
        List<String> list = Arrays.asList(word);
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> m : map.entrySet()){
            ans.add(m.getValue());
        }
    }


    public static void rotateRight(int[] nums, int start, int end){
        ++count;
        System.out.println(count+ " rotate "+ start + " start " +end + " end");
        while(start>end){
            System.out.println(start+ " "+end);
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            --start;
            ++end;
        }
    }

    public static void rotateLeft(int[] nums, int start, int end){
        while(start<end){
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }

    public static int[] kMostFrequent(int[] nums, int k){
        int[] ans = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int highest = Integer.MIN_VALUE;
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
            set.add(i);
            if(map.get(i)> highest)
                highest = i;
        }
        Map<Integer,Integer> sortedMap =  map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));
        int count =0;
        for(Map.Entry<Integer,Integer> s : sortedMap.entrySet()){
            ans[count++] = s.getValue();
        }
        return ans;
    }

    public static boolean checkSubArraySum(int[] nums, int target){
        List<Integer> v = new ArrayList<>();
        int a =0;
        int currSum = 0;
        for(int i : nums){
            currSum+=i;
            currSum%=target;
            v.add(currSum);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; ++i){
            if(set.contains(v.get(i)))
                return true;
            if(i == 0)
                set.add(0);
            else
                set.add(v.get(i));
        }
        return false;
    }
}
