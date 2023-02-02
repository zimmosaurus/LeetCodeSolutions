package com.hazim.code.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodeWars {
    public static void main(String[] args) {
        System.out.println(humanReadableTime(86399));
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
}
