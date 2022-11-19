package com.hazim.code;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeEasy {

    static Integer preVal530, ans530 = Integer.MAX_VALUE;
    static boolean ans100;
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,2,1};
        System.out.println(pickingNumber(arr));
        
    }

    public static boolean dfs_101(TreeNode r, TreeNode l){
        if(r == null || l == null)
            return l == r;
        if(r.val != l.val)
            return false;
        return dfs_101(r.left,l.right) && dfs_101(r.right, l.left);
    }

    public static void dfs_100(TreeNode r, TreeNode l){
        if(l != noll && r != null){
            if(l.left != r.right)
                ans100 = false;
            dfs_100(r.left, l.left);
            dfs_100(r.right, l.right);
        }else if (l == null && r == null) {
            return;
        }
        else
            ans100 = false;
    }

    public static void dfs_530(TreeNode root){
        //preVal = cache previous visited node value
        if(root == null)
            return ;
        dfs_530(root.left);
        if(preVal530 != null)
            ans530 = Math.min(ans530, Math.abs(root.val - preVal530));
        preVal530 = root.val;
        dfs_530(root.right);
    }


    public static int pickingNumber(int[] arr){
        Arrays.sort(arr);
        int ans = 0;
        int count = 0;
        for(int i = 1; i < arr.length; ++i){
            System.out.println(arr[i] + " " + arr[i-1] + " " + (arr[i]-arr[i-1] == 1));

            if(arr[i]-arr[i-1] == 1 || arr[i]-arr[i-1] == 0) {
                ++count;
                System.out.println(count);
            }
            else{
                ans = Math.max(ans,count);
                count = 0;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }

    public static void perm(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans + " ");
            return;
        }
        for(int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            System.out.println("index: "+ i + " str " + str + " ans " + ans);
            String s = str.substring(0,i) + str.substring(i+1);
            System.out.println("Perm of index i: "+i+" Char: "+ ch + " s: " +s);
            perm(s, ans + ch);
        }

    }

    public static boolean pairs(int[] arr){
        if(arr.length%2==1)
            return false;
        Arrays.sort(arr);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; ++i){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            if(i != 0 && arr[i]!=arr[i-1]){
                if(map.get(arr[i-1])%2==1)
                    return false;
            }
        }
        return true;
    }

    public static int solution(String s, int[] c){
        int ans = 0;
        for(int i = 0 ; i < c.length; ++i){
            if(i != 0 && s.charAt(i) == s.charAt(i-1)){
                ans+=Math.min(c[i],c[i-1]);
            }
        }
        return ans;
    }

    public static void solve(int num){
        StringBuilder sb = new StringBuilder();
        Integer.parseInt(sb.toString());
    }


    public static boolean isSubsequence(String s, String t){
        int l = t.length();
        int x = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            while(x < l){
                if(s.charAt(i) == t.charAt(x)) {
                    ++count;
                    break;
                }
                else
                    ++x;
            }
        }
        return count == s.length();
    }

    public static boolean wordPattern(String s, String words){
        Map<Character, String> map = new HashMap<>();
        String[] word = words.split(" ");
        for(int i = 0; i < word.length; i++){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),word[i]);
            else{
                if(!map.get(s.charAt(i)).equals(word[i]))
                    return false;
            }
        }
        return true;
    }

    public static int addDigits(int num){
        int ans = num/10 == 0 ? num : 0;
        while(num/10!=0){
            int r = num%10;
            int d = num/10;
            num = r + d;
            ans = num;
        }
        return ans;
    }

    public static boolean valueChar(String s){
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); ++i){
            int val = s.charAt(i) - 'a';
            System.out.println(s.charAt(i) + " val: " + val);
            if((val>=0 && val<=25) || (val<=-97 && val>=-88)){
                sb.append(s.charAt(i));
            }
        }
        String a = new String(sb);
        System.out.println(a);
        return a.equals(sb.reverse().toString());
    }

    public static int numOfUniqueEmail(String[] emails){
        Set<String> ans = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            String local = split[0];
            String domain = split[1];
            StringBuilder sb = new StringBuilder();
            for (char c : local.toCharArray()) {
                if (c == '+')
                    break;
                if (c == '.') {
                }
                else
                    sb.append(c);
            }
            sb.append(domain);
            ans.add(sb.toString());
        }
        return ans.size();
    }
    public static boolean rotateString(String s, String goal){
        char[] arr = s.toCharArray();

        for(int rot =0 ; rot < goal.length(); ++rot){

            if(String.valueOf(arr).equals(goal))
                return true;
            for(int i = 0 ; i+1 < s.length(); ++i){
                char temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        return false;
    }
    public static int[] sortByFrequency(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            list.add(i);
        }
        list.sort((a, b) -> map.get(a).equals(map.get(b)) ? b - a : map.get(a) - map.get(b));
        int[] ans = new int[nums.length];
        for(int i = 0 ; i < ans.length; ++i){
            ans[i] = list.get(i);
        }
        return ans;
//        return Arrays.stream(nums).boxed().sorted((a,b)->map.get(a) == map.get(b) ? b-a : map.get(a) - map.get(b)).mapToInt(a -> a).toArray();
    }

    public static int[] sortByBits(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[arr.length];
        for(int i : arr){
            int count = 0;
            int temp=i;
            while(i % 2 != 0){
                i = i >>> 1;
                count++;
            }
            if((i!=0 && i%2==0))
                count++;
            System.out.println("temp: "+ temp +" count: " + count);
            map.put(temp,count);
        }
        map = map.entrySet().stream().sorted((a,b)-> a.getValue().compareTo(b.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(x,y)->x, LinkedHashMap::new));
        int i = 0;
        for(Map.Entry<Integer,Integer> en:map.entrySet()){
            ans[i++] = en.getKey();
        }
        return ans;
    }

    public static String freqAlpha(String s){
        Map<String, Character> map = new HashMap<>();
        int k = 1;
        for(char c = 'a' ; c <= 'z' ; c++){
            if(c < 'j')
                map.put(String.valueOf(k++),c);
            else
                map.put(String.valueOf(k++)+'#',c);
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length() - 1;
        while(len >= 0){
            if(s.charAt(len) == '#'){
                sb.append(map.get(s.substring(len-2,len+1)));
                len-=3;
            }
            else{
                sb.append(map.get(s.substring(len,len+1)));
                --len;
            }
        }
        return sb.reverse().toString();
    }

    public static String lowerCase(String s){
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c:arr){
            if('A'<=c && c <= 'Z')
                c = (char) (c - 'A' + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    public static boolean searchMatrix(int[][] m, int t){
        for(int i = 0 ; i < m.length; ++i){
            for(int j = 0 ; j < m[0].length; j++){
                if(t>=m[i][0] && t<=m[i+1][0]){
                    if(t == m[i][0] || t == m[i+1][0])
                        return true;
                    if(t == m[i][j])
                        return true;
                }
            }
        }
        return false;
    }

    public static List<List<Integer>> pascalTriangle(int num){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < num ; ++i){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < i + 1 ; ++j){
                if(j == 0 || j == i){
                    list.add(1);
                }
                else{
                    int val = ans.get(i-1).get(j) + ans.get(i-1).get(j-1);
                    list.add(val);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static boolean anagram(String s, String t){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        for(char c: t.toCharArray()) {
            if (!map.containsKey(c))
                return false;
            map.put(c, map.get(c) - 1);
            if(map.get(c) == -1)
                return false;
        }
        return map.values().stream().reduce(0, Integer::sum) == 0;
    }

    public static String mergeStrings(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        int s1L = 0;
        int s2L = 0;
        while(s1L <s1.length() || s2L < s2.length()){
            if(s1L < s1.length())
                sb.append(s1.charAt(s1L++));
            if(s2L < s2.length())
                sb.append(s2.charAt(s2L++));

        }
        return new String(sb);
    }

    public static int firstUniqueChar(String s){
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0 ; i < arr.length ; ++i){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
            if(map.get(arr[i]) > 1){
                map.put(arr[i], map.get(arr[i])-1);
                map.remove(arr[i],0);
            }
        }
        int ans = -1;
        for(char c : arr){
            if(map.get(c) == 1)
                return s.indexOf(c);
        }
        return ans;


    }
    public static int[] arrIntersection(int[] nums1, int[] nums2){
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0 ; i  < nums1.length ; ++i){
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
        for(int i:nums2){
            if(map.containsKey(i)){
                ans.add(i);
                map.put(i, map.get(i)-1);
                map.remove(i,0);
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0 ; i < res.length ; ++i){
            res[i] = ans.get(i);
        }
        return res;
    }

    public static int sumOddArray(int[] nums){
        int ans = 0;
        //starting subarry = 0 - i --> i+1
        //ending subarray = n - i;
        // total of subArrays = (i + 1) * (n-i);
        // no. of odd length --> total/2 + 1;
        int n = nums.length;
        for(int i = 0 ; i < n; ++i){
            int start = i + 1;
            int end = n - i;
            int tot = start * end;
            int odd = tot%2 == 0 ? tot/2 : tot/2 +1;
            ans+=odd*nums[i];
        }
        return ans;
    }
    public static int[] greatestNextElemet(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i : nums2){
            while(!stack.isEmpty() && stack.peek() < i){
                System.out.println("Map: "+ stack.peek() + " num: " + i);
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for(int i = 0 ; i < nums1.length;++i){
              nums1[i] = map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
    public static void mergeSortedArrays(int[] nums1, int size1, int[] nums2, int size2){
        for(int i = 0 ; i < nums1.length ; ++i){
            int j = 0;
            while(j < 3){
                int val1 = nums1[i];
                int val2 = nums2[j];
                if(val2 < val1 && val2 != 0){
                    nums1[i] = val2;
                    nums2[j] = val1;
                    j = 0;
                } else {
                    ++j;
                }

            }
        }
    }

    public static int nearestValidPoint(int x , int y , int[][] points){
        int ans = Integer.MAX_VALUE;
        int dist = Integer.MAX_VALUE;
        for(int i = 0 ; i < points.length ; ++i){
            int x2 = points[i][0];
            int y2 = points[i][1];
            int temp = Math.abs(x-x2) + Math.abs(y-y2);
            // 1: 3,1[3] , 2: 2,4[1] , 4:4,4[1]
            if(temp <= dist){
                if (temp != dist)
                    ans = i;
                dist = temp;
            }
        }
        return ans;
    }

    public static int result(int n){
        int prod = 1;
        int sum = 0;
        String[] arr = (Integer.toString(n)).split("");
        for(String c : arr){
            int val = Integer.parseInt(c);
            prod*=val;
            sum+=val;
        }
        return (prod-sum);
    }

    public static int maxSubArray(int[] nums){
        if(nums.length == 0 )
            return 0;
        int maxSoFar = Integer.MIN_VALUE;
        int current = nums[0];
        for(int i = 1 ; i < nums.length ; ++i){
            current = Math.max(current, nums[i] + current);
            maxSoFar = Math.max(current,maxSoFar);
        }
        return maxSoFar;
    }
    public static double average(int[] salary){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int s : salary){
            min = Math.min(min,s);
            max = Math.max(min,s);
            sum+=s;
        }
        return (sum-max-min)/(salary.length-2);
    }

    public static String addBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int carry = 0;
        while(aIdx >= 0 || bIdx >=0){
            if(bIdx >= 0)
                carry+= b.charAt(bIdx--) - '0';
            if(aIdx >= 0)
                carry+= a.charAt(aIdx--) - '0';
            sb.append(carry%2);
            carry/=2;
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
    public static int[] plusOne(int[] digits){
        int len = digits.length;
        for(int i = len-1 ; i > -1 ; ++i){
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[len+1];
        ans[0] = 1;
        return ans;
    }
    public static List<List<Integer>> threeSum(int[] sums){
        Set<List<Integer>> set = new HashSet<>();
        if(sums.length == 0)
            return new ArrayList<>(set);
        Arrays.sort(sums);
        for(int i = 0 ; i < sums.length-2; ++i){
            int j = i + 1;
            int k = sums.length - 1;
            while(j < k){
                int sum = sums[i] + sums[j] + sums[k];
                if(sum == 0)
                    set.add(Arrays.asList(sums[i],sums[j],sums[k--]));
                else if (sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return new ArrayList<>(set);
    }

    public static int threeSumClosest(int[] nums, int target){
        if(nums.length == 3)
            return(nums[1] + nums[2] + nums[0]);
        int difference = Integer.MAX_VALUE;

        Map<Integer,Integer> diffMap = new HashMap<>();
        int sum = 0;
        int[] s = new int[(""+sum).toCharArray().length];
        Arrays.sort(nums);
        for(int i = 0 ;i < nums.length - 2; ++i){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                System.out.println("Sum: " + sum + " Difference: " + difference);
                difference = Math.min(Math.abs(target-sum),Math.abs(difference));
                if(Math.abs(target-sum) == difference) {
                    System.out.println("Add Difference Min: " + difference + " sum: " + sum);
                    diffMap.put(difference,sum);
                }
                if(sum > target)
                    --k;
                else
                    ++j;
            }

        }
//        difference = Math.min(target-sum, difference);
        return diffMap.get(difference);
    }


    // 3 2 2 3
    // 2 3 2
    //
    //
    public static int[] removeElements(int[] nums, int val){
        int right = 0;
        int left = 0;
        while (left < nums.length){
            if(nums[left] == val){
                if(nums[right] != val){
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                }
                else{
                    right++;
                }
            }
            else {
                ++left;
                ++right;
            }
        }
        return nums;
    }

    public static int sewerArea(int row, int col, int[] horizontal, int[] vertical){
        int ans = 0;
        Arrays.sort(horizontal);
        Arrays.sort(vertical);
        int maxHorizontal = Math.max(horizontal[0], row - horizontal[horizontal.length - 1]);
        int maxVertical = Math.max(vertical[0], col - vertical[vertical.length-1]);
        for(int i = 0 ; i < horizontal.length -1 ; ++i){
            maxHorizontal = Math.max(maxHorizontal, horizontal[i+1] - horizontal[i]);
        }
        for(int i = 0 ; i < vertical.length -1 ; ++i){
            maxVertical = Math.max(maxVertical, vertical[i+1] - vertical[i]);
        }
        ans = (int) ((long) maxHorizontal * maxVertical % 1000000007);
        return ans;
    }



    //2,9,3,2,3
    //
    //1,3,2,1,2
    public static List<Integer> alert(List<Integer> nums){
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> t = new TreeSet<>();
        for(int i : nums)
            t.add(i);
        int idx = 1;
        for(int i : t){
            if(!map.containsKey(i)) {
                map.put(i, idx);
                idx++;
            }
        }
        for(int i : nums)
            ans.add(map.get(i));

        return ans;

    }


    public static boolean isPalindrome(int x){
        String x_str = Integer.toString(x);
        char[] x_char = x_str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = x_char.length -1 ; i > -1 ; --i){
            sb.append(x_char[i]);
        }
        String rev_str = sb.toString();
        return rev_str.equals(x_str);
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            if(c == '[')
                stack.push(']');
            if(c == '{')
                stack.push('}');
            if(stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public int removeDuplicats(int[] nums){
        int idx = 0;
        int previous = nums[0];

        //0112 -> 012
        for(int i = 1 ; i < nums.length ; ++i) {
            if(nums[i] != previous){
                idx++;
            }
            previous = nums[i];
        }
        return idx+1;
    }
    public static List<Integer> sortByMostRepeat(List<Integer> nums){
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i,1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        List<Integer> store = new ArrayList<>();
        for(Map.Entry<Integer,Integer> r : list){
            sortedMap.put(r.getKey(), r.getValue());
            store.add(r.getKey());
        }
        int idx = 0;
        for(int i = 0 ; i < nums.size() ; ++i){
            if(sortedMap.get(store.get(idx)) == 0){
                ++idx;
            }
            ans.add(store.get(idx));
            sortedMap.put(store.get(idx), sortedMap.get(store.get(idx))-1);
        }
        return ans;
    }


    public static int romanToInt(String s){
        char[] ch = s.toCharArray();
        int[] nums = new int[ch.length];
        int val = 0;
        for(int i = 0 ; i < ch.length; ++i){
           char x = ch[i];
            if(x == 'I'){
                nums[i] = 1;
            }
            if(x == 'V'){
                nums[i] = 5;
            }
            if(x == 'X'){
                nums[i] = 10;
            }
            if(x == 'L'){
                nums[i] = 50;
            }
            if(x == 'C'){
                nums[i] = 100;
            }
            if(x == 'D'){
                nums[i] = 500;
            }
            if(x == 'M'){
                nums[i] = 1000;
            }
        }
        for(int i  = 0 ; i < nums.length-1; i++){
            if(nums[i] < nums[i+1])
                val-=nums[i];
            else
                val+=nums[i];
        }
        return val + nums[nums.length-1];
    }

}
