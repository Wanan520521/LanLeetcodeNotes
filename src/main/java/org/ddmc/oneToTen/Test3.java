package org.ddmc.oneToTen;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Lan
 * @date 2023/1/18
 */
//3.无重复字符的最长子串
//给定一个字符串s，找出不含重复字符的最长子串的长度
//0 <= s.length <= 5 * 104   s 由英文字母、数字、符号和空格组成
public class Test3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("asass"));
    }

    public static int lengthOfLongestSubString(String s) {
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

    }
}
