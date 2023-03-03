package org.ddmc;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Lan
 * @date 2023/1/18
 */
//无重复字符的最长子串
//给定一个字符串s，找出不含重复字符的最长子串的长度
//0 <= s.length <= 5 * 104   s 由英文字母、数字、符号和空格组成
public class Test3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("asass"));
    }

    public static int lengthOfLongestSubString(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;


        /*if (!hasRepeatCharacters(s)) {
            return s.length();
        }

        int result = 1;
        for (int i = 0; i < s.length(); i++) {
            if (!hasRepeatCharacters(s.substring(i, i + result + 1))) {
                result++;
                i = -1;
            }
            if (i == s.length() - result - 1 && hasRepeatCharacters(s.substring(i))) {
                return result;
            }
        }
        return result;*/
    }

    public static boolean hasRepeatCharacters(String s) {
        char[] charArray = s.toCharArray();
        HashSet<Character> chars = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) {
            chars.add(charArray[i]);
        }
        return chars.size() < charArray.length;

        /*for (int i = 0; i < charArray.length; i++) {
            for (int i1 = i + 1; i1 < charArray.length; i1++) {
                if (charArray[i] == charArray[i1]) {
                    return true;
                }
            }
        }
        return false;*/
    }
}
