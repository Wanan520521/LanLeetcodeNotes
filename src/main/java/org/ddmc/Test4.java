package org.ddmc;

import java.util.*;

/**
 * @author Lan
 * @date 2023/11/8
 */
//49 字母异位词分组
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//示例 1:
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//示例 2:
//
//输入: strs = [""]
//输出: [[""]]
//示例 3:
//
//输入: strs = ["a"]
//输出: [["a"]]
    // 结论 两种方法作为哈希表的key    1 排序  2 计数  自己用了计数，但逻辑有点复杂导致超出时间限制
public class Test4 {

    public static void main(String[] args) {
        String[] strings = new String[]{"", ""};
        List<List<String>> lists = groupAnagrams(strings);
        System.out.println(lists);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<String> strings = new ArrayList<>(Arrays.asList(strs));
        List<List<String>> groupAnagrams = new ArrayList<>();

        while (!strings.isEmpty()) {
            String currentString = strings.get(0);
            List<String> groupAnagramList = new ArrayList<>();
            groupAnagramList.add(currentString);

            for (int i = 1; i < strings.size(); i++) {
                if (isAnagram(currentString, strings.get(i))) {
                    groupAnagramList.add(strings.get(i));
                }
            }

            groupAnagrams.add(groupAnagramList);
            strings.removeAll(groupAnagramList);
        }

        return groupAnagrams;
    }

    /*public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        ArrayList<String> originGroup = new ArrayList<>();
        originGroup.add(strs[0]);
        groupAnagrams.add(originGroup);
        if (strs.length == 1){
            return groupAnagrams;
        }
        for (int i = 1; i < strs.length; i++) {
            Iterator<List<String>> iterator = groupAnagrams.iterator();
            boolean flag = false;
            while (iterator.hasNext()) {
                List<String> groupAnagram = iterator.next();
                for (String s : groupAnagram) {
                    if (isAnagram(s, strs[i])) {
                        groupAnagram.add(strs[i]);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                ArrayList<String> newGroup = new ArrayList<>();
                newGroup.add(strs[i]);
                groupAnagrams.add(newGroup);
            }
        }
        return groupAnagrams;
    }*/

    /*public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        Map<Integer,Boolean> addedGroup = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (addedGroup.get(i) !=null){
                continue;
            }
            List<String> groupAnagramList = new ArrayList<>();
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i],strs[j])){
                    groupAnagramList.add(strs[j]);
                    addedGroup.put(i,true);
                    addedGroup.put(j,true);
                }
            }
            if (addedGroup.get(i) == null){
                ArrayList<String> as = new ArrayList<String>();
                String a = strs[i];
                as.add(a);
                groupAnagrams.add(as);
            }else {
                groupAnagramList.add(strs[i]);
            }
            if (!groupAnagramList.isEmpty()){
                groupAnagrams.add(groupAnagramList);
            }
        }
        return groupAnagrams;
    }*/

    public static boolean isAnagram(String wordA, String wordB) {
        if (wordA.length() != wordB.length()) {
            return false;
        }
        char[] charsA = wordA.toCharArray();
        char[] charsB = wordB.toCharArray();
        Map<Character, Integer> charTimesA = new HashMap<>();
        Map<Character, Integer> charTimesB = new HashMap<>();
        putCharTimes(charsA, charTimesA);
        putCharTimes(charsB, charTimesB);
        return charTimesA.equals(charTimesB);
    }

    private static void putCharTimes(char[] chars, Map<Character, Integer> charTimes) {
        for (int i = 0; i < chars.length; i++) {
            if (charTimes.containsKey(chars[i])) {
                charTimes.put(chars[i], charTimes.get(chars[i]) + 1);
            } else {
                charTimes.put(chars[i], 1);
            }
        }
    }
}
