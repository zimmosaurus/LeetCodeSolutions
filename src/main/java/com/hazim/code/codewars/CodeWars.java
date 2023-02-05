package com.hazim.code.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class CodeWars {
    public static void main(String[] args) {
        double[] s = {16.0,8.0,10.0};
        System.out.println(tribonacci(s,18));

    }
    public static double[] tribonacci(double[] s, int n){
        if(n == 0)
            return new double[3];
        double ans[] = new double[n];
        for(int i = 0 ; i < s.length ; ++i)
            ans[i] = s[i];
        for(int i = s.length; i < n ; ++i){
            ans[i] = ans[i-1] + ans[i-2] + ans[i-3];
        }
        return ans;
    }
    public static String masking(String name){
        if(name.length() > 4){
            String last4Chars = name.substring(name.length()-4);
            String remainingChars = name.substring(0,name.length()-4);
            for(int i = 0; i < remainingChars.length() ; ++i){
                remainingChars = remainingChars.replace(remainingChars.charAt(i),'#');
            }
            name = remainingChars + last4Chars;
        }
        return name;
    }

    public static List<Object> filteredList (final List<Object> list){
        List<Object> ans = new ArrayList<>();
        for(Object o : list){
            if(o instanceof Integer){
                ans.add(o);
            }
        }
        return ans;
    }
    public static int sortDesc(final int num){
        String str = Integer.toString(num);
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        int ans = 0, i =1, len = arr.length;
        for(int t = len-1; t > -1 ; --t){
            System.out.println(arr[t]);
            System.out.println(Math.pow(10,len-i) * (int) arr[t]);
            ans+=Math.pow(10,len-i) * arr[t];
            ++i;
        }
        return ans;
    }
    public static int multiplesOf3Or5(int n){
        if(n<=0)
            return 0;
        int s = 0;
        for(int i = 1; i < n ; ++i){
            if(i%3 == 0 || i % 5 == 0)
                s+=i;
        }
        return s;
    }

    public static String[] stringSplit(String s){
        s = s.length()%2 == 0 ? s : s.concat("_");
        String[] ans = new String[s.length()/2];
        int c = 0;
        for(int i = 0 ; i < s.length(); i+=2){
            ans[c++] = s.substring(i,i+2);
        }
        return ans;
    }
    public static String humanReadableTime(int s){
        int hours = s/3600;
        String HH = hours%10 != hours ? Integer.toString(hours) : "0".concat(Integer.toString(hours));
        s = s%3600;
        int min = s/60;
        String MM = min%10 != min ? Integer.toString(min) : "0".concat(Integer.toString(min));
        s = s%60;
        int secs = s;
        String SS = secs%10 != secs? Integer.toString(secs) : "0".concat(Integer.toString(secs));
        return HH.concat(":").concat(MM).concat(":").concat(SS);
    }
    public static String spaceCamelCase(String s){
        StringBuilder sb = new StringBuilder();
        char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int start = 0;
        /**
         * Alternative to single-line code
         * s.replaceAll("[A-Z]", " $1");
         */
        for(int  i = 0 ; i < s.length() ; ++i){
            //Capital letter
            if(s.charAt(i) - 'A' <= 25 && s.charAt(i)>=0){
                String word = s.substring(start,i);
                sb.append(word.concat(" "));
                start = i;
            }
        }
        if(start != 0){
            sb.append(s.substring(start));
        }
        if(sb.length() == 0){
            sb.append(s);
        }
        return sb.toString().trim();
    }

    public static boolean validBracket(String s){
        Stack<Character> stack = new Stack<>();
//        for(int i = 0 ; i < s.length()/2; ++i){
//            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
//                stack.push(s.charAt(i));
//            }
//        }
//        for(int i = s.length()/2 ; i < s.length(); ++i){
//            char c = stack.pop();
//            if(c == '[')
//                if(s.charAt(i) != ']')
//                    return false;
//            if(c == '{')
//                if(s.charAt(i) != '}')
//                    return false;
//            if(c == '(')
//                if(s.charAt(i) != ')')
//                    return false;
//        }
//        return true;

        for(int i = 0 ; i < s.length(); ++i){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                char c = stack.peek();
                if(c == '[')
                  if(s.charAt(i) != ']')
                    return false;
                if(c == '{')
                    if(s.charAt(i) != '}')
                        return false;
                if(c == '(')
                    if(s.charAt(i) != ')')
                        return false;
                stack.pop();
            }
        }
        return true;
    }

    public static int evenOrOdd(int[] i){
        List<Integer> evenL = new ArrayList<>();
        List<Integer> oddL = new ArrayList<>();
        for(int c : i){
            if(c%2==0)
                evenL.add(c);
            else
                oddL.add(c);
        }
        return evenL.size() == 1 ? evenL.get(0) : oddL.get(0);
    }
}
