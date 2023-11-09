package org.ddmc;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * @author Lan
 * @date 2023/11/9
 */

//128.最长连续序列
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//示例 1：
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//示例 2：
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 自己第一次做中等难度通过且时间超越90+的人,自己理解本题核心就是排序~ 可惜 排序时间复杂度为o(n log n) 最终看题解，最优解均为哈希表＋动态规划
// 记录下，写个题解~ https://leetcode.cn/problems/longest-consecutive-sequence/solutions/2519110/zui-chang-lian-xu-xu-lie-lian-xu-dang-ra-yfix/
public class Test5 {
    static int[] nums = new int[]{9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};

    public static void main(String[] args) {
        out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int a = 1;
        int b = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                a++;
            } else if (nums[i + 1] - nums[i] != 0) {
                if (a > b) {
                    b = a;
                }
                a = 1;
            }
        }
        return Math.max(a, b);
    }
}
